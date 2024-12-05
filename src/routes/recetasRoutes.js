import Router from 'express';
import { recetasController } from '../controllers/recetas/recetasController.js';
const router = Router();

const { getRecetas, selectByID, selectByUserID } = recetasController;

router.get('/recetas', getRecetas);
router.get('/recetas/:id', selectByID);
router.get('/recetas-usuario/:id', selectByUserID);

export default router;
