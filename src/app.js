import express from 'express';
import path, { join, dirname } from 'path';
import { fileURLToPath } from 'url';
import multer from 'multer';
import cors from 'cors';
import cookieParser from 'cookie-parser';
import jwt from 'jsonwebtoken';
import rutas from './routes/api.js';
import {PORT, URL_FRONTEND, SECRET_JWT_KEY} from './config.js';

// Initialización
const app = express();
const __dirname = dirname(fileURLToPath(import.meta.url));

const storage = multer.diskStorage({
    destination: (req, file, cb) => {
      cb(null, 'public/uploads/'); // Carpeta donde se guardarán las imágenes
    },
    filename: (req, file, cb) => {
      cb(null, Date.now() + path.extname(file.originalname)); // Renombrar el archivo
    }
  });

const upload = multer({ storage: storage });

// Middlewares
app.use(express.urlencoded({ extended: false }));
app.use(express.json());
app.use(cookieParser());
app.use(cors({
  origin: URL_FRONTEND,
  credentials: true
}));

app.use((req, res, next) => {
  const token = req.cookies.access_token;
  let data = null;
  req.session = { user: null };
  
  try {
    data = jwt.verify(token, SECRET_JWT_KEY);
    req.session.user = data;
  } catch (error) {
    req.session.user = null;
    
  }
  next(); // ->Continua con las rutas de api
});

app.use('/api', rutas);


app.use('/public/uploads', express.static('uploads'));

/*
// Ruta para manejar la carga de imágenes
app.post('/upload', upload.single('image'), (req, res) => {
  if (!req.file) {
    return res.status(400).send('No se ha subido ningún archivo.');
  }
  // Aquí puedes realizar otras acciones, como guardar información en la base de datos.
  res.json({ imageUrl: `/public/uploads/${req.file.filename}` }); // Ajustado aquí
});
*/

// Public files
app.use(express.static(join(__dirname, 'public')));

// Run server
app.listen(PORT, () =>{
    console.log(`Servidor corriendo en http://127.0.0.1:${PORT}`);
});