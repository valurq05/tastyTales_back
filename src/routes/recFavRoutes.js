import Router from 'express';
import { recetasFavController } from '../controllers/recetasFavoritas/recetasFavController.js';
const router = Router();

const { getRecetasFavoritas, postRecetasFavoritas } = recetasFavController;

router.get('/recetas-favoritas/:id', getRecetasFavoritas);
router.post('/recetas-favoritas', postRecetasFavoritas);

export default router;
