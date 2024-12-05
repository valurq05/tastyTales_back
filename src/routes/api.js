import { Router } from "express";
import authRoutes from './authRoutes.js';
import usuariosRoutes from './usuariosRoutes.js';
import adicionalesRoutes from './adicionalesRoutes.js';
import calfRecRoutes from './calfRecRoutes.js';
import recetasRoutes from './recetasRoutes.js';

const router = Router();

router.get('/', (req, res) => {
    const { user } = req.session
    if (!user) return res.json({user: null});
    res.send(user);
});

// Obtenemos las rutas de los controladores

router.use(authRoutes);
router.use(usuariosRoutes);
router.use(adicionalesRoutes);
router.use(adicionalesRoutes);
router.use(calfRecRoutes);
router.use(recetasRoutes);

export default router;