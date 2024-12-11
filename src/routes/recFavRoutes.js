import Router from 'express';
import { recetasFavController } from '../controllers/recetasFavoritas/recetasFavController.js';
const router = Router();

const { getRecetasFavoritas } = recetasFavController;

router.get('/recetas-favoritas/:id', getRecetasFavoritas);
router.get('/recetas-usuario/:id');

export default router;
