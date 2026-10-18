// --- SINTETIZADOR DE AUDIO (Melodía de Tetris Completa) ---
class SoundEngine {
  constructor() {
    this.ctx = null;
    this.musicTimeout = null;
    this.isMusicPlaying = false;
    this.currentNoteIndex = 0;

    // Melodía completa de Tetris (Korobeiniki)
    this.tetrisMelody = [
      // Frase A
      { note: 659.25, duration: 0.35 }, { note: 493.88, duration: 0.18 },
      { note: 523.25, duration: 0.18 }, { note: 587.33, duration: 0.35 },
      { note: 523.25, duration: 0.18 }, { note: 493.88, duration: 0.18 },
      { note: 440.00, duration: 0.35 }, { note: 440.00, duration: 0.18 },
      { note: 523.25, duration: 0.18 }, { note: 659.25, duration: 0.35 },
      { note: 587.33, duration: 0.18 }, { note: 523.25, duration: 0.18 },
      { note: 493.88, duration: 0.35 }, { note: 523.25, duration: 0.18 },
      { note: 587.33, duration: 0.35 }, { note: 659.25, duration: 0.35 },
      { note: 523.25, duration: 0.35 }, { note: 440.00, duration: 0.35 },
      { note: 440.00, duration: 0.35 },

      // Frase B
      { note: 587.33, duration: 0.35 }, { note: 698.46, duration: 0.18 },
      { note: 880.00, duration: 0.35 }, { note: 783.99, duration: 0.18 },
      { note: 698.46, duration: 0.18 }, { note: 659.25, duration: 0.50 },
      { note: 523.25, duration: 0.18 }, { note: 659.25, duration: 0.35 },
      { note: 587.33, duration: 0.18 }, { note: 523.25, duration: 0.18 },
      { note: 493.88, duration: 0.35 }, { note: 493.88, duration: 0.18 },
      { note: 523.25, duration: 0.18 }, { note: 587.33, duration: 0.35 },
      { note: 659.25, duration: 0.35 }, { note: 523.25, duration: 0.35 },
      { note: 440.00, duration: 0.35 }, { note: 440.00, duration: 0.35 },

      // Frase C (Cierre)
      { note: 659.25, duration: 0.35 }, { note: 523.25, duration: 0.35 },
      { note: 587.33, duration: 0.35 }, { note: 493.88, duration: 0.35 },
      { note: 523.25, duration: 0.35 }, { note: 440.00, duration: 0.35 },
      { note: 415.30, duration: 0.35 }, { note: 493.88, duration: 0.35 },
      { note: 659.25, duration: 0.35 }, { note: 523.25, duration: 0.35 },
      { note: 587.33, duration: 0.35 }, { note: 493.88, duration: 0.35 },
      { note: 523.25, duration: 0.18 }, { note: 659.25, duration: 0.18 },
      { note: 880.00, duration: 0.35 }, { note: 830.61, duration: 0.50 }
    ];
  }

  init() {
    if (!this.ctx) {
      this.ctx = new (window.AudioContext || window.webkitAudioContext)();
    }
  }

  playTone(freq, type, duration, delay = 0) {
    if (!this.ctx) return;
    setTimeout(() => {
      const osc = this.ctx.createOscillator();
      const gain = this.ctx.createGain();
      osc.type = type;
      osc.frequency.setValueAtTime(freq, this.ctx.currentTime);
      gain.gain.setValueAtTime(0.06, this.ctx.currentTime);
      gain.gain.exponentialRampToValueAtTime(0.0001, this.ctx.currentTime + duration);
      osc.connect(gain);
      gain.connect(this.ctx.destination);
      osc.start();
      osc.stop(this.ctx.currentTime + duration);
    }, delay * 1000);
  }

  soundStart() {
    this.init();
    this.playTone(440, 'sine', 0.1, 0);
    this.playTone(554.37, 'sine', 0.1, 0.1);
    this.playTone(659.25, 'sine', 0.2, 0.2);
  }

  soundSuccess() {
    this.init();
    this.playTone(523.25, 'triangle', 0.1, 0);
    this.playTone(659.25, 'triangle', 0.15, 0.08);
  }

  soundError() {
    this.init();
    this.playTone(200, 'sawtooth', 0.15, 0);
    this.playTone(150, 'sawtooth', 0.25, 0.1);
  }

  soundWin() {
    this.init();
    const notes = [523.25, 659.25, 783.99, 1046.50];
    notes.forEach((n, i) => this.playTone(n, 'square', 0.2, i * 0.12));
  }

  soundLose() {
    this.init();
    const notes = [311.13, 293.66, 277.18, 261.63, 220.00];
    notes.forEach((n, i) => this.playTone(n, 'sawtooth', 0.35, i * 0.22));
  }

  playTetrisMusic() {
    if (!this.isMusicPlaying) return;

    // Modifica estos valores (ej. Math.max(550, 800 - ...)) si deseas ralentizar la música
    const speedFactor = Math.max(380, 800 - (currentErrors * 28));
    const currentNote = this.tetrisMelody[this.currentNoteIndex];

    this.playTone(currentNote.note, 'square', currentNote.duration * 0.85);

    this.currentNoteIndex++;

    if (this.currentNoteIndex >= this.tetrisMelody.length) {
      this.currentNoteIndex = 0;
    }

    this.musicTimeout = setTimeout(() => {
      this.playTetrisMusic();
    }, currentNote.duration * speedFactor);
  }

  toggleMusic(enable) {
    this.init();
    if (enable && !this.isMusicPlaying) {
      this.isMusicPlaying = true;
      this.currentNoteIndex = 0;
      this.playTetrisMusic();
    } else if (!enable && this.isMusicPlaying) {
      this.isMusicPlaying = false;
      clearTimeout(this.musicTimeout);
    }
  }
}

const sound = new SoundEngine();

// --- BANCO DE MÁS DE 500 PALABRAS COMUNES EN ESPAÑOL (7-10 LETRAS) ---
function generateWords() {
  const commonWords = [
    "ABOGADO", "ACADEMIA", "ACATAR", "ACCIDENTE", "ACCIONES", "ACEPTAR", "ACERTAR", "ACOMPAÑAR",
    "ACORDAR", "ACTITUD", "ACTIVIDAD", "ACUERDO", "ACUSAR", "ADAPTAR", "ADELANTE", "ADEMAS",
    "ADJUNTAR", "ADOPTAR", "ADULTO", "AFECTAR", "AFIRMAR", "AGENCIA", "AGREGAR", "AGRICOLA",
    "AGRADECER", "AGUARDAR", "AGUJERO", "AHORRAR", "ALAMBRE", "ALCANCE", "ALCANZAR", "ALEGRIA",
    "ALENTAR", "ALIANZA", "ALINEAR", "ALQUILER", "ALTERAR", "ALUMNO", "AMABLE", "AMATEUR",
    "AMBIENTE", "AMENAZA", "AMISTAD", "AMPLIAR", "ANALISIS", "ANALIZAR", "ANATOMIA", "ANGULO",
    "ANIMAL", "ANOTACION", "ANTECEDER", "ANTIGUO", "ANUNCIO", "APARATO", "APARECER", "APARTAR",
    "APELACION", "APELAR", "APERTURA", "APLICAR", "APOYAR", "APRECIAR", "APRENDER", "APROBAR",
    "APROVECHAR", "APUESTA", "APUNTAR", "AQUEL", "ARBITRO", "ARCHIVO", "ARGUIR", "ARMADURA",
    "ARQUEOLOGO", "ARRANCAR", "ARREGLAR", "ARRIESGAR", "ARROJAR", "ARTICULO", "ARTISTA", "ASEGURAR",
    "ASAMBLEA", "ASENTAR", "ASESINO", "ASIENTO", "ASIGNAR", "ASISTIR", "ASOCIAR", "ASPECTO",
    "ASPIRAR", "ASUNTO", "ATACAR", "ATENCION", "ATRAVESAR", "ATRACTIVO", "AUMENTAR", "AUSENCIA",
    "AUTOBUS", "AUTONOMO", "AVANZAR", "AVENTURA", "AVERIGUAR", "BANCARIO", "BANDERA", "BARBERO",
    "BARRERA", "BASICO", "BATALLA", "BELLEZA", "BENEFICIO", "BIBLIOTECA", "BIENVENIDA", "BILLETE",
    "BIOLOGIA", "BLANQUERIA", "BLOQUEAR", "BOMBERO", "BONDAD", "BOSQUE", "BOTELLA", "BRUJULA",
    "CABALLERO", "CABALGAR", "CABECERA", "CADENA", "CALCULAR", "CALIDAD", "CAMBIAR", "CAMINAR",
    "CAMPANA", "CAMPEON", "CAMPANARIO", "CANCION", "CANDIDATO", "CANTANTE", "CAPACIDAD", "CAPITAL",
    "CAPITULO", "CAPTURA", "CAPTURAL", "CARACTER", "CARAMELO", "CARGAMENTO", "CARRETERA", "CASTIGO",
    "CASTILLO", "CATEDRAL", "CATEGORIA", "CELEBRAR", "CEMENTERIO", "CENACULO", "CENTRAL", "CENTRO",
    "CERCANO", "CEREBRO", "CEREMONIA", "CERTEZA", "CERVEZA", "CICLISMO", "CIENCIA", "CIENTIFICO",
    "CIGARRILLO", "CINEASTA", "CIRCULO", "CIRCULAR", "CIUDADANO", "CIVILIZAR", "CLARIDAD", "CLIENTE",
    "COBRANZA", "COCINERO", "COLECTIVO", "COLEGIO", "COLAPSO", "COLABORAR", "COLECCION", "COLOQUIO",
    "COMBATIR", "COMEDOR", "COMENZAR", "COMERCIO", "COMEDIA", "COMENTARIO", "COMETAR", "COMIDA",
    "COMIENZO", "COMISION", "COMPAÑERO", "COMPAÑIA", "COMPARAR", "COMPARTIR", "COMPENSAR", "COMPETIR",
    "COMPLEJO", "COMPLEXION", "COMPRAR", "COMPROMISO", "COMPUTAR", "COMUNICAR", "COMUNIDAD", "CONCEPTO",
    "CONCERTAR", "CONCLUIR", "CONCURSO", "CONDICION", "CONDUCIR", "CONECTAR", "CONFESAR", "CONFIAR",
    "CONFIRMAR", "CONFLITO", "CONFORMAR", "CONGESTION", "CONOCER", "CONOCIDO", "CONSEJO", "CONSEGUIR",
    "CONSENSO", "CONSERVAR", "CONSIDERAR", "CONSOLAR", "CONSPIRAR", "CONSTANTE", "CONSTRUIR", "CONSULTAR",
    "CONSUMIR", "CONTACTO", "CONTAR", "CONTENER", "CONTENTO", "CONTESTAR", "CONTEXTO", "CONTINUO",
    "CONTRATO", "CONTROL", "CONVENIR", "CONVERSAR", "CONVERTIR", "CONVOCAR", "CORAZON", "CORRECTO",
    "CORREGIR", "CORREO", "CORRER", "CRIATURA", "CRITERIO", "CRITICAR", "CRUCERO", "CUADRO",
    "CUALIDAD", "CUARENTENA", "CUARTEL", "CUADERNO", "CUENTA", "CUENTO", "CUERPO", "CUESTION",
    "CULTURA", "CUMPLIR", "DENTISTA", "DEPORTE", "DEPORTISTA", "DERROTA", "DERROTAR", "DESAFIO",
    "DESAPARECER", "DESARROLLO", "DESCANSO", "DESCUBRIR", "DESEAR", "DESIERTO", "DESGANO", "DESIGNAR",
    "DESPACHO", "DESPERTAR", "DESPEGAR", "DESPLAZAR", "DESECHO", "DESPEDIDA", "DESTINO", "DESTRUIR",
    "DETALLE", "DETERMINAR", "DIABOLICO", "DIAGNOSTICO", "DIALECTO", "DIALOGO", "DIAMANTE", "DIARIO",
    "DIBUJAR", "DICCIONARIO", "DICTADURA", "DIETETICO", "DIFERENCIA", "DIFICULTAD", "DIFUNDIR", "DIGITAL",
    "DIGNIDAD", "DINAMICO", "DINAMITA", "DINASTIA", "DINERO", "DINOSAURIO", "DIPLOMA", "DIPLOMATICO",
    "DIRECCION", "DIRECTOR", "DISCIPLINA", "DISCOTECA", "DISCURSO", "DISCUTIR", "DISENADORA", "DISFRUTAR",
    "DISCURRIR", "DISPOSITIVO", "DISTANCIA", "DISTINTO", "DIVERTIDO", "DIVIDIR", "DIVISION", "DOCTORADO",
    "DOCUMENTO", "DOMICILIO", "DOMINGO", "DONACION", "DORMITORIO", "DRAMATICO", "DURADERO", "ECOLOGIA",
    "ECONOMIA", "ECLIPSE", "EDIFICIO", "EDITORIAL", "EDUCACION", "EFECTIVO", "EFICACIA", "EFICIENTE",
    "EJECUTAR", "EJEMPLO", "EJERCICIO", "EJERCITO", "ELABORAR", "ELECCIONES", "ELEGANTE", "ELEMENTO",
    "ELEVADOR", "ELIMINAR", "EMBAJADA", "EMBARCACION", "EMBARGO", "EMBLEMA", "EMERGENCIA", "EMIGRANTE",
    "EMOCION", "EMPLEADO", "EMPRESA", "ENAMORAR", "ENCANTO", "ENCENDER", "ENCERRAR", "ENCONTRAR",
    "ENEMIGO", "ENERGIA", "ENFERMERO", "ENFOQUE", "ENGANAR", "ENORME", "ENSENANZA", "ENTENDER",
    "ENTERAR", "ENTERRAR", "ENTRADA", "ENTREGAR", "ENTRENAR", "ENTREVISTA", "ENTUSIASMO", "EQUIPAJE",
    "EQUILIBRIO", "ESCENARIO", "ESCLAVO", "ESCRITOR", "ESCRITORIO", "ESCUELA", "ESCUCHAR", "ESCULTURA",
    "ESFUERZO", "ESPACIAL", "ESPAÑOL", "ESPECIAL", "ESPECTACULO", "ESPEJO", "ESPERANZA", "ESPIAR",
    "ESPIRITU", "ESPLENDOR", "ESPOSA", "ESPOSO", "ESQUELETO", "ESQUEMA", "ESTACION", "ESTADIO",
    "ESTADO", "ESTAMPA", "ESTANDAR", "ESTATUA", "ESTETICA", "ESTILO", "ESTIMAR", "ESTIMULO",
    "ESTRATEGIA", "ESTRELLA", "ESTRUCTURA", "ESTUDIAR", "ESTUDIANTE", "ESTUDIO", "ETIQUETA", "EVALUAR",
    "EVALUACION", "EVENTO", "EVIDENCIA", "EVOLUCION", "EXAMEN", "EXAMINAR", "EXCELENCIA", "EXCEPCION",
    "EXCESIVO", "EXCURSION", "EXHIBICION", "EXIGENCIA", "EXISTENCIA", "EXOTICO", "EXPANSION", "EXPEDICION",
    "EXPERIENCIA", "EXPERIMENTO", "EXPERTOS", "EXPLICAR", "EXPLORAR", "EXPLOSION", "EXPORTAR", "EXPOSICION",
    "EXPRESAR", "EXPRESION", "EXTRANJERO", "EXTREMO", "FABRICA", "FACULTAD", "FANTASIA", "FANTASMA",
    "FARMACIA", "FASCINANTE", "FAVORITO", "FELICIDAD", "FEMENINO", "FENOMENO", "FESTIVAL", "FIGURA",
    "FILOSOFIA", "FINALIZAR", "FINANCIERO", "FIRMEZA", "FISIOLOGIA", "FLAMENCO", "FLEXIBLE", "FLORECER",
    "FONTANERO", "FORESTAL", "FORMULARIO", "FORTALEZA", "FORTUNA", "FOTOGRAFIA", "FRACASO", "FRAGIL",
    "FRAGMENTO", "FONDOS", "FRONTERA", "FRUSTRAR", "FUEGOS", "FUNERARIA", "FUSION", "FUTBOLISTA",
    "GALAXIA", "GALERIA", "GANANCIAS", "GARANTIA", "GARAGE", "GASOLINA", "GASTRONOMIA", "GENERACION",
    "GENERADOR", "GENERAL", "GENEROSO", "GENETICA", "GENIAL", "GEOGRAFIA", "GEOMETRIA", "GIMNASIO",
    "GINECOLOGO", "GIRASOL", "GLADIADOR", "GLACIAL", "GLORIA", "GOBIERNO", "GOLONDRINA", "GOLPEAR",
    "GOLOSINA", "GRABACION", "GRACIAS", "GRAFICO", "GRAMATICA", "GRANDEZA", "GRATUITO", "GRAVEDAD",
    "GUARDIA", "GUARDAR", "GUERRA", "GUITARRISTA", "GUSTAR", "HABITANTE", "HABITAR", "HABITO",
    "HABILIDAD", "HACIENDA", "HALCON", "HAMBURTUE", "HARINA", "HECHIZO", "HELICOPTERO", "HERMANO",
    "HERRAMIENTA", "HEROICO", "HIDRAULICO", "HIGIENE", "HISTORIA", "HISTORIADOR", "HOMENAJE", "HORIZONTE",
    "HOSPITAL", "HOSTELERIA", "HOTELERIA", "HUMANIDAD", "HUMILDE", "HUMORISMO", "HURACAN", "IDENTIDAD",
    "IDEOLOGIA", "IGLESIA", "IGNORAR", "ILUMINAR", "ILUSION", "ILUSTRACION", "IMAGINAR", "IMAGINARIO",
    "IMITACION", "IMPACTO", "IMPEDIR", "IMPERIAL", "IMPERIO", "IMPLACABLE", "IMPLANTAR", "IMPORTAR",
    "IMPOSIBLE", "IMPRENTA", "IMPRESION", "IMPRESO", "IMPULSO", "INCENDIO", "INCIDENTE", "INCLINAR",
    "INCLUIR", "INCOMODO", "INCOGNITA", "INCREIBLE", "INDICADOR", "INDICAR", "INDIVIDUO", "INDUSTRIA",
    "INFANCIA", "INFANTERIA", "INFECCION", "INFERIOR", "INFINITO", "INFLUENCIA", "INFORME", "INFORMACION",
    "INFORMATICA", "INGENIERO", "INGENIO", "INGRESAR", "INICIAR", "INICIATIVA", "INMENSIDAD", "INMIGRANTE",
    "INMORTAL", "INMUNIDAD", "INNOVACION", "INNOVADOR", "INSECTO", "INSERTAR", "INSISTIR", "INSPECCION",
    "INSPIRAR", "INSTALAR", "INSTINTO", "INSTITUTO", "INSTRUCCION", "INSTRUMENTO", "INSULINA", "INTEGRAR",
    "INTELIGENCIA", "INTENCION", "INTENSIDAD", "INTERES", "INTERIOR", "INTERNET", "INTERPRETE", "INTERRUPTOR",
    "INTERVALO", "INTERVENCION", "INTESTINO", "INTIMIDAD", "INTRODUCCION", "INVASION", "INVENTAR", "INVENTO",
    "INVERSION", "INVESTIGAR", "INVIERNO", "INVITACION", "INVITAR", "INYECTAR", "IZQUIERDA", "JARDINERIA",
    "JERARQUIA", "JUBILACION", "JUGADOR", "JUGUETE", "JURAMENTO", "JUSTICIA", "JUVENTUD", "LABORATORIO",
    "LADRON", "LAGUNA", "LANCERO", "LANZAMIENTO", "LARGUERO", "LENGUAJE", "LEYENDA", "LIBERAR",
    "LIBERTAD", "LIBRERIA", "LICENCIA", "LITERATURA", "LOCALIZAR", "LOCUTOR", "LOGICA", "LOGISTICA",
    "LONGITUD", "LUMINESCENTE", "MADRUGADA", "MAGISTRADO", "MAGNITUD", "MAJESTAD", "MALETA", "MAMIFERO",
    "MANANTIAL", "MANTENER", "MAQUINARIA", "MARAVILLA", "MARISCO", "MARKETING", "MATEMATICA", "MATERIA",
    "MATRIMONIO", "MECANISMO", "MEDICINA", "MEDITACION", "MEDIOAMBIENTE", "MELODIA", "MEMORIA", "MENCIONAR",
    "MENSANERO", "MENTALIDAD", "MERCADO", "MERCANCIA", "MERECE", "METEORITO", "METODOLOGIA", "METROPOLE",
    "MICROFONO", "MICROSCOPIO", "MISTERIO", "MITOLOGIA", "MOCHILA", "MODERNIDAD", "MOLESTIA", "MONASTERIO",
    "MONEDA", "MONUMENTO", "MORALIDAD", "MOTIVACION", "MOVIMIENTO", "MULTITUD", "MUNICIPIO", "NACIONAL",
    "NATURALEZA", "NAVEGACION", "NECESIDAD", "NEGOCIACION", "NEUMATICO", "NOSTALGIA", "NOVEDAD", "NOVIEMBRE",
    "NUTRICION", "OBJETIVO", "OBLIGACION", "OBSERVAR", "OBSTACULO", "OCTUBRE", "OFICINA", "OLIMPIADA",
    "OPERACION", "OPINION", "OPORTUNIDAD", "ORQUESTA", "PACIENCIA", "PALACIO", "PANTALLA", "PARADOJA",
    "PARAGUAS", "PARROQUIA", "PARTICIPAR", "PARTICULA", "PARTIDO", "PASAPORTE", "PATRIMONIO", "PATRULLA",
    "PAISAJE", "PELICULA", "PENSAMIENTO", "PERMISO", "PERSONAL", "PERSPECTIVA", "PESADILLA", "PETROLEO",
    "PINTURA", "PIRAMIDE", "PLANETA", "PLATAFORMA", "POBLACION", "POLICIA", "POLITICA", "PORCENTAJE",
    "POSIBILIDAD", "PRESIDENTE", "PRESUPUESTO", "PRIMAVERA", "PRINCIPIO", "PROBLEMA", "PRODUCCION", "PROFESOR",
    "PROGRAMA", "PROTECCION", "PROTOCOLO", "PROVINCIA", "PSICOLOGIA", "PUBLICIDAD", "QUIROFANO", "RADIOGRAFIA",
    "REACCION", "REALIDAD", "RECEPTOR", "RECURSO", "REDACCION", "REFLEXION", "REFORMA", "REGISTRO",
    "REGLAMENTO", "RELACION", "RELIGION", "RENDIMIENTO", "REPUBLICANO", "REQUISITO", "RESISTENCIA", "RESOLUCION",
    "RESPUESTA", "RESTAURANTE", "RESULTADO", "RESUMEN", "REUNION", "REVOLUCION", "SABIDURIA", "SACRIFICIO",
    "SANATORIO", "SATELITE", "SECRETARIO", "SEGURIDAD", "SELECCION", "SEMANAL", "SEMINARIO", "SENSACION",
    "SENTIMIENTO", "SEPARACION", "SERPIENTE", "SERVICIO", "SILENCIO", "SIMPATIA", "SISTEMA", "SITUACION",
    "SOCIEDAD", "SOLUCION", "SUBMARINO", "SUPERFICIE", "TELEFONO", "TELEVISION", "TEMPERATURA", "TEMPLADO",
    "TENDENCIA", "TERRETERO", "TERRITORIO", "TESTIGO", "TESORO", "TIBURON", "TOLERANCIA", "TRADICION",
    "TRANSPORTE", "TRAYECTORIA", "TRIBUNAL", "TRILOGIA", "TRISTEZA", "TRIUNFO", "UBICACION", "UNIVERSIDAD",
    "URBANISMO", "VACACIONES", "VALENTIA", "VARIEDAD", "VEGETACION", "VELOCIDAD", "VENTANA", "VERIFICAR",
    "VICTORIA", "VIOLINISTA", "VISUALIZAR", "VOCABULARIO", "VOLUNTAD", "ZAPATERIA"
  ];

  const wordSet = new Set();
  const shuffled = commonWords.sort(() => 0.5 - Math.random());

  for (let w of shuffled) {
    let clean = w.toUpperCase().replace(/[^A-ZÑ]/g, '');
    if (clean.length >= 7 && clean.length <= 10) {
      wordSet.add(clean);
    }
  }

  return Array.from(wordSet);
}

// --- ESTADO DEL JUEGO ---
let wordList = generateWords();
let currentWord = "";
let guessedWord = [];
let usedLetters = new Set();
let currentScore = 0;
let lastScore = 0;
let maxScore = 0;
let currentErrors = 0;
const MAX_ERRORS = 7;
let gameActive = false;

const hangmanPartsOrder = [
  ['base', 'pole', 'beam', 'rope'],
  ['head'],
  ['body'],
  ['arm-left'],
  ['arm-right'],
  ['leg-left'],
  ['leg-right']
];

// --- ELEMENTOS DOM ---
const wordDisplay = document.getElementById('wordDisplay');
const virtualKeyboard = document.getElementById('virtualKeyboard');
const usedLettersList = document.getElementById('usedLettersList');
const btnStart = document.getElementById('btnStart');
const scoreCurrentEl = document.getElementById('scoreCurrent');
const scoreLastEl = document.getElementById('scoreLast');
const scoreMaxEl = document.getElementById('scoreMax');
const errorsCurrentEl = document.getElementById('errorsCurrent');
const wordsRemainingEl = document.getElementById('wordsRemaining');
const toggleMusic = document.getElementById('toggleMusic');
const modal = document.getElementById('gameModal');
const modalTitle = document.getElementById('modalTitle');
const modalBody = document.getElementById('modalBody');
const modalClose = document.getElementById('modalClose');

// --- INICIALIZAR TECLADO VIRTUAL ---
function createKeyboard() {
  virtualKeyboard.innerHTML = '';
  const alphabet = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".split('');
  alphabet.forEach(letter => {
    const btn = document.createElement('button');
    btn.className = 'key-btn';
    btn.textContent = letter;
    btn.dataset.letter = letter;
    btn.disabled = true;
    btn.addEventListener('click', () => handleLetterGuess(letter));
    virtualKeyboard.appendChild(btn);
  });
}

function updateKeyboardAndUsedList() {
  const buttons = virtualKeyboard.querySelectorAll('.key-btn');
  buttons.forEach(btn => {
    const letter = btn.dataset.letter;
    if (!gameActive) {
      btn.disabled = true;
      return;
    }

    if (usedLetters.has(letter)) {
      btn.disabled = true;
      if (currentWord.includes(letter)) {
        btn.classList.add('correct');
      } else {
        btn.classList.add('wrong');
      }
    } else {
      btn.disabled = false;
      btn.className = 'key-btn';
    }
  });

  usedLettersList.innerHTML = '';
  usedLetters.forEach(letter => {
    const tag = document.createElement('span');
    const isCorrect = currentWord.includes(letter);
    tag.className = `used-tag ${isCorrect ? 'correct' : 'wrong'}`;
    tag.textContent = letter;
    usedLettersList.appendChild(tag);
  });
}

function updateHangmanDrawing() {
  const parts = document.querySelectorAll('#hangmanSvg .draw-part');
  parts.forEach(part => {
    if (part.classList.contains('base') || part.classList.contains('pole') || 
        part.classList.contains('beam') || part.classList.contains('rope')) {
      part.classList.add('visible');
    } else {
      part.classList.remove('visible');
    }
  });

  for (let i = 1; i <= currentErrors; i++) {
    if (hangmanPartsOrder[i]) {
      hangmanPartsOrder[i].forEach(className => {
        const el = document.querySelector(`#hangmanSvg .${className}`);
        if (el) el.classList.add('visible');
      });
    }
  }
}

function updateUI(isNewGame = false) {
  scoreCurrentEl.textContent = currentScore;
  scoreLastEl.textContent = lastScore;
  scoreMaxEl.textContent = maxScore;
  errorsCurrentEl.textContent = currentErrors;
  wordsRemainingEl.textContent = wordList.length;

  wordDisplay.innerHTML = '';
  guessedWord.forEach((char, index) => {
    const box = document.createElement('div');
    box.className = 'letter-box';
    if (isNewGame) {
      box.classList.add('pop-in');
      box.style.animationDelay = `${index * 0.05}s`;
    }
    box.textContent = char !== '_' ? char : '';
    wordDisplay.appendChild(box);
  });

  updateKeyboardAndUsedList();
  updateHangmanDrawing();
}

function showModal(title, message) {
  modalTitle.textContent = title;
  modalBody.textContent = message;
  modal.style.display = 'flex';
}

function closeModal() {
  modal.style.display = 'none';
}

function startGame() {
  if (wordList.length === 0) {
    showModal("Fin del juego", "No quedan más palabras en el banco.");
    return;
  }

  sound.soundStart();

  const randomIndex = Math.floor(Math.random() * wordList.length);
  currentWord = wordList.splice(randomIndex, 1)[0];

  guessedWord = Array(currentWord.length).fill('_');
  usedLetters.clear();
  currentErrors = 0;
  currentScore = 0;
  gameActive = true;

  updateUI(true);
}

function handleLetterGuess(letter) {
  if (!gameActive || usedLetters.has(letter)) return;

  usedLetters.add(letter);

  let matches = 0;
  for (let i = 0; i < currentWord.length; i++) {
    if (currentWord[i] === letter && guessedWord[i] === '_') {
      guessedWord[i] = letter;
      matches++;
    }
  }

  if (matches > 0) {
    sound.soundSuccess();
    const scoreEarned = matches * (MAX_ERRORS - currentErrors);
    currentScore += scoreEarned;

    if (!guessedWord.includes('_')) {
      sound.soundWin();
      gameActive = false;
      lastScore = currentScore;
      if (currentScore > maxScore) maxScore = currentScore;
      showModal("¡Has ganado!", `¡Enhorabuena! Has adivinado la palabra "${currentWord}". Puntuación: ${currentScore}`);
    }
  } else {
    sound.soundError();
    currentErrors++;
    if (currentErrors >= MAX_ERRORS) {
      sound.soundLose();
      gameActive = false;
      
      // Revelar la palabra completa en el tablero
      guessedWord = currentWord.split('');
      
      lastScore = currentScore;
      if (currentScore > maxScore) maxScore = currentScore;
      
      // Ventana modal simétrica
      showModal("¡Has perdido!", `Has alcanzado el número máximo de fallos permitidos. La palabra a adivinar era "${currentWord}". Puntuación final: ${currentScore}`);
    }
  }

  updateUI();
}

// Soporte para teclado físico
document.addEventListener('keydown', (e) => {
  if (!gameActive) return;
  const key = e.key.toUpperCase();
  if (/^[A-ZÑ]$/.test(key)) {
    handleLetterGuess(key);
  }
});

// Event Listeners
btnStart.addEventListener('click', startGame);
modalClose.addEventListener('click', closeModal);
toggleMusic.addEventListener('change', (e) => {
  sound.toggleMusic(e.target.checked);
});

// Inicialización
createKeyboard();
wordsRemainingEl.textContent = wordList.length;