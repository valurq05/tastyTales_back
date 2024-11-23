import { Router } from "express";
import authRoutes from './authRoutes.js';
import usuariosRoutes from './usuariosRoutes.js';

const router = Router();

router.get('/', (req, res) => {
    const { user } = req.session
    if (!user) return res.json({user: null});
    res.send(user);
});

// Obtenemos las rutas de los controladores

router.use(authRoutes);
router.use(usuariosRoutes);

export default router;