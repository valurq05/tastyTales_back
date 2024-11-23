import Router from 'express';
import { authController } from '../controllers/auth/authController.js';
const router = Router();

const { loginUser, registerUser, logout } = authController;

router.post('/login', loginUser);
router.post('/register', registerUser);
router.post('/logout', logout);

export default router;
