import { Router } from "express";
import { calfRecController } from '../controllers/calificacionRecetas/calfRecController.js';

const router = Router();

const { getCalfRec, selectByID, postCalfRec } = calfRecController;
router.get('/calificacion-recetas', getCalfRec);
router.get('/calificacion/:id', selectByID);
router.post('/calificacion', postCalfRec);

export default router;