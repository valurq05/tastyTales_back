import { Router } from "express";
import { calfRecController } from '../controllers/calificacionRecetas/calfRecController.js';

const router = Router();

const { getCalfRec, selectByID } = calfRecController;
router.get('/calificacion-recetas', getCalfRec);
router.get('/calificacion/:id', selectByID);

export default router;