import Router from 'express';
import { recetasController } from '../controllers/recetas/recetasController.js';
const router = Router();

const { getRecetas, selectByID } = recetasController;

router.get('/recetas', getRecetas);
router.get('/recetas/:id', selectByID);

export default router;
