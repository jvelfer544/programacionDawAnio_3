// ==========================================
// VOCAB TRAINER PRO - VERSIÓN LOCAL (LOCALSTORAGE)
// Con edición de palabras, modo práctica (EN->ES, ES->EN, Mixto) y prevención de duplicados
// ==========================================

// Limpieza automática inmediata de cualquier resto de conflicto de Git en el DOM
(function cleanGitConflictArtifacts() {
  function clean() {
    const walker = document.createTreeWalker(document.documentElement, NodeFilter.SHOW_TEXT);
    const toRemove = [];
    while (walker.nextNode()) {
      const node = walker.currentNode;
      if (node.nodeValue && (node.nodeValue.includes("<<<<<<<") || node.nodeValue.includes(">>>>>>>") || node.nodeValue.includes("======="))) {
        toRemove.push(node);
      }
    }
    toRemove.forEach(n => n.remove());
  }
  if (document.readyState === "loading") {
    document.addEventListener("DOMContentLoaded", clean);
  } else {
    clean();
  }
  // Ejecutar también tras medio segundo por si algún contenido tardó en montarse
  setTimeout(clean, 500);
})();

const USERS_KEY = "vocab_app_users";
const SESSION_KEY = "vocab_app_session";

function getWordsKey(email) {
  return "vocab_words_" + email.toLowerCase().trim();
}

// Elementos del DOM - Generales y Login
const statusMessage = document.getElementById("statusMessage");
const loginSection = document.getElementById("loginSection");
const mainSection = document.getElementById("mainSection");
const userDisplay = document.getElementById("userDisplay");

const emailInput = document.getElementById("email");
const passwordInput = document.getElementById("password");
const btnLogin = document.getElementById("btnLogin");
const btnRegister = document.getElementById("btnRegister");
const btnLogout = document.getElementById("btnLogout");

// Pestañas
const tabVocab = document.getElementById("tabVocab");
const tabPractice = document.getElementById("tabPractice");
const viewVocab = document.getElementById("viewVocab");
const viewPractice = document.getElementById("viewPractice");

// Elementos - Formulario y Gestión de Vocabulario
const formTitle = document.getElementById("formTitle");
const enInput = document.getElementById("en");
const esInput = document.getElementById("es");
const catInput = document.getElementById("cat");
const btnAddWord = document.getElementById("btnAddWord");
const btnCancelEdit = document.getElementById("btnCancelEdit");
const lista = document.getElementById("lista");
const wordCount = document.getElementById("wordCount");
const btnExport = document.getElementById("btnExport");
const importFileInput = document.getElementById("importFile");

// Elementos - Modo Práctica
const practiceDirection = document.getElementById("practiceDirection");
const btnRestartPractice = document.getElementById("btnRestartPractice");
const practiceArea = document.getElementById("practiceArea");
const practiceEmpty = document.getElementById("practiceEmpty");
const practiceSummary = document.getElementById("practiceSummary");

const practiceProgress = document.getElementById("practiceProgress");
const practiceScore = document.getElementById("practiceScore");
const practiceDirectionLabel = document.getElementById("practiceDirectionLabel");
const promptWord = document.getElementById("promptWord");
const promptCategory = document.getElementById("promptCategory");
const practiceAnswerInput = document.getElementById("practiceAnswerInput");
const practiceFeedback = document.getElementById("practiceFeedback");

const btnCheckAnswer = document.getElementById("btnCheckAnswer");
const btnNextWord = document.getElementById("btnNextWord");
const btnSkipWord = document.getElementById("btnSkipWord");
const btnPlayAgain = document.getElementById("btnPlayAgain");
const summaryScoreText = document.getElementById("summaryScoreText");

// Estado global de la aplicación
let currentUser = null;
let editingWordId = null; // ID de la palabra en edición (o null si se está agregando una nueva)

// Estado del modo práctica
let practiceQueue = [];
let practiceIndex = 0;
let scoreCorrect = 0;
let scoreWrong = 0;
let currentQuestion = null;

// ==========================================
// 1. INICIALIZACIÓN Y DETECCIÓN DE SESIÓN
// ==========================================
function initApp() {
  const sessionData = localStorage.getItem(SESSION_KEY);
  if (sessionData) {
    try {
      currentUser = JSON.parse(sessionData);
      mostrarSeccionPrincipal();
    } catch (e) {
      localStorage.removeItem(SESSION_KEY);
      mostrarSeccionLogin();
    }
  } else {
    mostrarSeccionLogin();
  }
}

function mostrarSeccionPrincipal() {
  loginSection.style.display = "none";
  mainSection.style.display = "block";
  userDisplay.textContent = currentUser.email;
  hideStatus();
  cancelEdit();
  switchTab("vocab");
  cargarPalabras();
}

function mostrarSeccionLogin() {
  loginSection.style.display = "block";
  mainSection.style.display = "none";
  userDisplay.textContent = "";
  lista.innerHTML = "";
  cancelEdit();
  hideStatus();
}

// ==========================================
// 2. SISTEMA DE PESTAÑAS (TABS)
// ==========================================
function switchTab(tab) {
  hideStatus();
  if (tab === "vocab") {
    tabVocab.classList.add("active");
    tabPractice.classList.remove("active");
    viewVocab.style.display = "block";
    viewPractice.style.display = "none";
    cargarPalabras();
  } else if (tab === "practice") {
    if (editingWordId) cancelEdit();
    tabPractice.classList.add("active");
    tabVocab.classList.remove("active");
    viewPractice.style.display = "block";
    viewVocab.style.display = "none";
    iniciarModoPractica();
  }
}

// ==========================================
// 3. AUTENTICACIÓN LOCAL
// ==========================================
function getUsers() {
  const users = localStorage.getItem(USERS_KEY);
  return users ? JSON.parse(users) : [];
}

function saveUsers(users) {
  localStorage.setItem(USERS_KEY, JSON.stringify(users));
}

function login() {
  const email = emailInput.value.trim().toLowerCase();
  const password = passwordInput.value;

  if (!email || !password) {
    showStatus("Por favor, introduce tu email y contraseña.", "error");
    return;
  }

  const users = getUsers();
  const foundUser = users.find(u => u.email === email && u.password === password);

  if (!foundUser) {
    showStatus("Email o contraseña incorrectos. Si aún no tienes cuenta, pulsa en 'Crear cuenta'.", "error");
    return;
  }

  currentUser = { email: foundUser.email };
  localStorage.setItem(SESSION_KEY, JSON.stringify(currentUser));

  passwordInput.value = "";
  mostrarSeccionPrincipal();
  showStatus(`¡Bienvenido de nuevo, ${currentUser.email}!`, "success", 3000);
}

function register() {
  const email = emailInput.value.trim().toLowerCase();
  const password = passwordInput.value;

  if (!email || !password) {
    showStatus("Introduce un email y contraseña para crear tu cuenta.", "error");
    return;
  }

  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) {
    showStatus("Introduce un formato de email válido (ej: usuario@correo.com).", "error");
    return;
  }

  if (password.length < 4) {
    showStatus("La contraseña debe tener al menos 4 caracteres.", "error");
    return;
  }

  const users = getUsers();
  const exists = users.some(u => u.email === email);

  if (exists) {
    showStatus("Este correo ya está registrado. Pulsa 'Entrar' para iniciar sesión.", "error");
    return;
  }

  users.push({ email, password });
  saveUsers(users);

  currentUser = { email };
  localStorage.setItem(SESSION_KEY, JSON.stringify(currentUser));

  passwordInput.value = "";
  mostrarSeccionPrincipal();
  showStatus("¡Cuenta creada exitosamente! Has iniciado sesión.", "success", 3500);
}

function logout() {
  currentUser = null;
  localStorage.removeItem(SESSION_KEY);
  mostrarSeccionLogin();
  showStatus("Has cerrado sesión con éxito.", "success", 2500);
}

// ==========================================
// 4. GESTIÓN DE PALABRAS (AGREGAR, EDITAR, ELIMINAR)
// ==========================================
function getWords() {
  if (!currentUser) return [];
  const words = localStorage.getItem(getWordsKey(currentUser.email));
  return words ? JSON.parse(words) : [];
}

function saveWords(words) {
  if (!currentUser) return;
  localStorage.setItem(getWordsKey(currentUser.email), JSON.stringify(words));
}

function updateWordInStorage(updatedWord) {
  const words = getWords();
  const index = words.findIndex(w => w.id === updatedWord.id);
  if (index !== -1) {
    words[index] = updatedWord;
    saveWords(words);
  }
}

// Agregar nueva palabra o Guardar edición existente
function saveWord() {
  if (!currentUser) return;

  const en = enInput.value.trim().toLowerCase();
  const es = esInput.value.trim().toLowerCase();
  const cat = catInput.value.trim().toLowerCase() || "general";

  if (!en || !es) {
    showStatus("Completa al menos la palabra en Inglés y su traducción en Español.", "error");
    return;
  }

  const words = getWords();

  // CONTROL ESTRICTO DE DUPLICADOS:
  // Se ignora la palabra que se está editando para permitir modificar otros campos
  const duplicateEn = words.find(w => w.en === en && w.id !== editingWordId);
  if (duplicateEn) {
    showStatus(`La palabra en inglés "${en}" ya está registrada en otra entrada (traducida como "${duplicateEn.es}").`, "error");
    enInput.focus();
    return;
  }

  const duplicateEs = words.find(w => w.es === es && w.id !== editingWordId);
  if (duplicateEs) {
    showStatus(`La palabra en español "${es}" ya está registrada en otra entrada (para "${duplicateEs.en}").`, "error");
    esInput.focus();
    return;
  }

  if (editingWordId) {
    // MODO EDICIÓN: Actualizar palabra existente
    const wordIndex = words.findIndex(w => w.id === editingWordId);
    if (wordIndex !== -1) {
      words[wordIndex].en = en;
      words[wordIndex].es = es;
      words[wordIndex].cat = cat;
      saveWords(words);
      showStatus(`¡Palabra "${en}" actualizada correctamente!`, "success", 2500);
    }
    cancelEdit();
  } else {
    // MODO CREACIÓN: Agregar nueva palabra
    const nuevaPalabra = {
      id: "w_" + Date.now() + "_" + Math.random().toString(36).substring(2, 6),
      en,
      es,
      cat,
      createdAt: Date.now(),
      level: 0,
      stats: { correct: 0, wrong: 0 }
    };

    words.unshift(nuevaPalabra);
    saveWords(words);

    enInput.value = "";
    esInput.value = "";
    catInput.value = "";
    enInput.focus();

    showStatus(`¡"${en}" agregada a tu vocabulario!`, "success", 2500);
  }

  cargarPalabras();
}

// Iniciar edición de una palabra
function startEditWord(id) {
  const words = getWords();
  const word = words.find(w => w.id === id);
  if (!word) return;

  editingWordId = id;
  enInput.value = word.en;
  esInput.value = word.es;
  catInput.value = word.cat || "";

  formTitle.textContent = "✏️ Editar palabra";
  btnAddWord.textContent = "💾 Guardar cambios";
  btnCancelEdit.style.display = "inline-block";

  enInput.focus();
  cargarPalabras();
}

// Cancelar edición y volver al modo de agregar
function cancelEdit() {
  editingWordId = null;
  enInput.value = "";
  esInput.value = "";
  catInput.value = "";

  formTitle.textContent = "Agregar nueva palabra";
  btnAddWord.textContent = "Agregar palabra";
  btnCancelEdit.style.display = "none";

  cargarPalabras();
}

function cargarPalabras() {
  if (!currentUser) return;

  const words = getWords();
  lista.innerHTML = "";

  wordCount.textContent = `${words.length} ${words.length === 1 ? "palabra" : "palabras"}`;

  if (words.length === 0) {
    lista.innerHTML = "<li class='empty-state'>Aún no tienes palabras guardadas.<br>¡Agrega tu primera palabra arriba!</li>";
    return;
  }

  words.forEach(p => {
    const li = document.createElement("li");
    if (p.id === editingWordId) {
      li.classList.add("editing");
    }

    li.innerHTML = `
      <div class="word-content">
        <span class="word-main">${escapeHTML(p.en)}</span>
        <span class="word-arrow">→</span>
        <span class="word-trans">${escapeHTML(p.es)}</span>
        <span class="word-cat">${escapeHTML(p.cat || 'general')}</span>
      </div>
      <div class="word-actions">
        <button class="btn-edit" title="Editar esta palabra">✏️</button>
        <button class="btn-delete" title="Eliminar esta palabra">✕</button>
      </div>
    `;

    const btnEdit = li.querySelector(".btn-edit");
    btnEdit.addEventListener("click", () => startEditWord(p.id));

    const btnDel = li.querySelector(".btn-delete");
    btnDel.addEventListener("click", () => deleteWord(p.id));

    lista.appendChild(li);
  });
}

function deleteWord(id) {
  if (!confirm("¿Deseas eliminar esta palabra de tu lista?")) return;

  if (editingWordId === id) {
    cancelEdit();
  }

  let words = getWords();
  words = words.filter(w => w.id !== id);
  saveWords(words);

  cargarPalabras();
  showStatus("Palabra eliminada.", "success", 2000);
}

// ==========================================
// 5. MODO ENTRENAMIENTO / PRÁCTICA (TRAINER)
// ==========================================
function iniciarModoPractica() {
  const words = getWords();

  if (words.length === 0) {
    practiceArea.style.display = "none";
    practiceSummary.style.display = "none";
    practiceEmpty.style.display = "block";
    return;
  }

  practiceEmpty.style.display = "none";
  practiceSummary.style.display = "none";
  practiceArea.style.display = "block";

  // Barajar aleatoriamente la cola de palabras
  practiceQueue = shuffleArray([...words]);
  practiceIndex = 0;
  scoreCorrect = 0;
  scoreWrong = 0;

  cargarTarjetaPractica();
}

function cargarTarjetaPractica() {
  if (practiceIndex >= practiceQueue.length) {
    // Ronda completada
    practiceArea.style.display = "none";
    practiceSummary.style.display = "block";
    const total = practiceQueue.length;
    const porcentaje = Math.round((scoreCorrect / total) * 100);
    summaryScoreText.innerHTML = `
      Has practicado <strong>${total}</strong> palabras.<br>
      Aciertos: <strong style="color:#4CAF50;">${scoreCorrect}</strong> | 
      Fallos: <strong style="color:#ef5350;">${scoreWrong}</strong><br>
      Precisión: <strong>${porcentaje}%</strong>
    `;
    return;
  }

  const word = practiceQueue[practiceIndex];
  const mode = practiceDirection.value; // "en-es", "es-en", "mixed"

  let prompt = "";
  let expected = "";
  let label = "";

  if (mode === "en-es") {
    prompt = word.en;
    expected = word.es;
    label = "🇬🇧 Inglés ➔ Traduce al Español:";
  } else if (mode === "es-en") {
    prompt = word.es;
    expected = word.en;
    label = "🇪🇸 Español ➔ Traduce al Inglés:";
  } else {
    // Mixto aleatorio (50% en-es, 50% es-en)
    if (Math.random() < 0.5) {
      prompt = word.en;
      expected = word.es;
      label = "🇬🇧 Inglés ➔ Traduce al Español:";
    } else {
      prompt = word.es;
      expected = word.en;
      label = "🇪🇸 Español ➔ Traduce al Inglés:";
    }
  }

  currentQuestion = {
    prompt,
    expected,
    category: word.cat,
    wordRef: word
  };

  // Actualizar DOM
  practiceProgress.textContent = `Palabra ${practiceIndex + 1} de ${practiceQueue.length}`;
  practiceScore.textContent = `Aciertos: ${scoreCorrect} | Fallos: ${scoreWrong}`;
  practiceDirectionLabel.textContent = label;
  promptWord.textContent = prompt;
  promptCategory.textContent = word.cat || "general";

  practiceAnswerInput.value = "";
  practiceAnswerInput.disabled = false;
  practiceFeedback.style.display = "none";

  btnCheckAnswer.style.display = "block";
  btnNextWord.style.display = "none";
  btnSkipWord.style.display = "block";

  practiceAnswerInput.focus();
}

function checkAnswer() {
  if (!currentQuestion) return;

  const userAnswer = practiceAnswerInput.value.trim();

  if (!userAnswer) {
    showPracticeFeedback("Escribe tu respuesta antes de comprobar.", "warning");
    return;
  }

  // Comparación tolerante (ignora mayúsculas y acentos diacríticos)
  const isCorrect = normalizeText(userAnswer) === normalizeText(currentQuestion.expected);

  currentQuestion.wordRef.stats = currentQuestion.wordRef.stats || { correct: 0, wrong: 0 };

  if (isCorrect) {
    scoreCorrect++;
    currentQuestion.wordRef.stats.correct++;
    showPracticeFeedback(`🎉 ¡Excelente! "${currentQuestion.expected}" es correcto.`, "success");
  } else {
    scoreWrong++;
    currentQuestion.wordRef.stats.wrong++;
    showPracticeFeedback(`❌ Incorrecto. La respuesta correcta es: <strong>${escapeHTML(currentQuestion.expected)}</strong>`, "error");
  }

  // Guardar estadísticas actualizadas
  updateWordInStorage(currentQuestion.wordRef);

  // Actualizar vista
  practiceScore.textContent = `Aciertos: ${scoreCorrect} | Fallos: ${scoreWrong}`;
  practiceAnswerInput.disabled = true;
  btnCheckAnswer.style.display = "none";
  btnSkipWord.style.display = "none";
  btnNextWord.style.display = "block";
  btnNextWord.focus();
}

function skipWord() {
  if (!currentQuestion) return;

  scoreWrong++;
  currentQuestion.wordRef.stats = currentQuestion.wordRef.stats || { correct: 0, wrong: 0 };
  currentQuestion.wordRef.stats.wrong++;
  updateWordInStorage(currentQuestion.wordRef);

  showPracticeFeedback(`ℹ️ La solución es: <strong>${escapeHTML(currentQuestion.expected)}</strong>`, "warning");

  practiceScore.textContent = `Aciertos: ${scoreCorrect} | Fallos: ${scoreWrong}`;
  practiceAnswerInput.disabled = true;
  btnCheckAnswer.style.display = "none";
  btnSkipWord.style.display = "none";
  btnNextWord.style.display = "block";
  btnNextWord.focus();
}

function nextWord() {
  practiceIndex++;
  cargarTarjetaPractica();
}

function showPracticeFeedback(html, type) {
  practiceFeedback.className = `feedback-msg ${type}`;
  practiceFeedback.innerHTML = html;
  practiceFeedback.style.display = "block";
}

// ==========================================
// 6. EXPORTAR / IMPORTAR (JSON)
// ==========================================
function exportar() {
  if (!currentUser) return;

  const words = getWords();
  if (words.length === 0) {
    showStatus("No hay palabras guardadas para exportar.", "warning", 3000);
    return;
  }

  const exportData = words.map(w => ({
    en: w.en,
    es: w.es,
    cat: w.cat || "general",
    level: w.level || 0,
    stats: w.stats || { correct: 0, wrong: 0 }
  }));

  const blob = new Blob([JSON.stringify(exportData, null, 2)], { type: "application/json" });
  const url = URL.createObjectURL(blob);

  const fecha = new Date().toISOString().slice(0, 10);
  const a = document.createElement("a");
  a.href = url;
  a.download = `vocabulario_${currentUser.email.split('@')[0]}_${fecha}.json`;
  document.body.appendChild(a);
  a.click();
  document.body.removeChild(a);
  URL.revokeObjectURL(url);

  showStatus("Copia de seguridad descargada correctamente.", "success", 3000);
}

function importar(event) {
  if (!currentUser) return;

  const file = event.target.files[0];
  if (!file) return;

  const reader = new FileReader();

  reader.onload = function(e) {
    try {
      const data = JSON.parse(e.target.result);

      if (!Array.isArray(data)) {
        throw new Error("El archivo no contiene una lista de palabras válida.");
      }

      const words = getWords();
      let agregadas = 0;
      let duplicadasOmitidas = 0;

      data.forEach(p => {
        if (p.en && p.es) {
          const en = String(p.en).trim().toLowerCase();
          const es = String(p.es).trim().toLowerCase();
          const cat = String(p.cat || "general").trim().toLowerCase();

          // Comprobar si ya existe en inglés o español
          const existe = words.some(w => w.en === en || w.es === es);
          if (!existe) {
            words.push({
              id: "w_" + Date.now() + "_" + Math.random().toString(36).substring(2, 6),
              en,
              es,
              cat,
              createdAt: Date.now(),
              level: p.level || 0,
              stats: p.stats || { correct: 0, wrong: 0 }
            });
            agregadas++;
          } else {
            duplicadasOmitidas++;
          }
        }
      });

      saveWords(words);
      cargarPalabras();

      let msg = `¡Se importaron ${agregadas} palabras nuevas!`;
      if (duplicadasOmitidas > 0) {
        msg += ` (${duplicadasOmitidas} omitidas por ser duplicadas)`;
      }
      showStatus(msg, "success", 4000);
    } catch (err) {
      showStatus("Error al leer el archivo JSON: " + err.message, "error");
    } finally {
      importFileInput.value = "";
    }
  };

  reader.readAsText(file);
}

// ==========================================
// 7. UTILIDADES
// ==========================================
function showStatus(message, type = "error", autoHideMs = 0) {
  statusMessage.className = `status-msg ${type}`;
  statusMessage.innerHTML = message;
  statusMessage.style.display = "block";

  if (autoHideMs > 0) {
    setTimeout(() => {
      hideStatus();
    }, autoHideMs);
  }
}

function hideStatus() {
  statusMessage.style.display = "none";
  statusMessage.innerHTML = "";
}

function escapeHTML(str) {
  return String(str || "")
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/"/g, "&quot;")
    .replace(/'/g, "&#039;");
}

function normalizeText(text) {
  return String(text || "")
    .trim()
    .toLowerCase()
    .normalize("NFD")
    .replace(/[\u0300-\u036f]/g, ""); // Elimina acentos/tildes para evitar frustración
}

function shuffleArray(array) {
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }
  return array;
}

// ==========================================
// 8. ASOCIACIÓN DE EVENTOS
// ==========================================
btnLogin.addEventListener("click", login);
btnRegister.addEventListener("click", register);
btnLogout.addEventListener("click", logout);

tabVocab.addEventListener("click", () => switchTab("vocab"));
tabPractice.addEventListener("click", () => switchTab("practice"));

btnAddWord.addEventListener("click", saveWord);
btnCancelEdit.addEventListener("click", cancelEdit);
btnExport.addEventListener("click", exportar);
importFileInput.addEventListener("change", importar);

practiceDirection.addEventListener("change", () => iniciarModoPractica());
btnRestartPractice.addEventListener("click", () => iniciarModoPractica());
btnCheckAnswer.addEventListener("click", checkAnswer);
btnNextWord.addEventListener("click", nextWord);
btnSkipWord.addEventListener("click", skipWord);
btnPlayAgain.addEventListener("click", () => iniciarModoPractica());

// Manejo inteligente de la tecla ENTER
emailInput.addEventListener("keydown", (e) => { if (e.key === "Enter") login(); });
passwordInput.addEventListener("keydown", (e) => { if (e.key === "Enter") login(); });
enInput.addEventListener("keydown", (e) => { if (e.key === "Enter") saveWord(); });
esInput.addEventListener("keydown", (e) => { if (e.key === "Enter") saveWord(); });
catInput.addEventListener("keydown", (e) => { if (e.key === "Enter") saveWord(); });

practiceAnswerInput.addEventListener("keydown", (e) => {
  if (e.key === "Enter") {
    if (btnCheckAnswer.style.display !== "none") {
      checkAnswer();
    } else if (btnNextWord.style.display !== "none") {
      nextWord();
    }
  }
});

// Arrancar aplicación
initApp();
