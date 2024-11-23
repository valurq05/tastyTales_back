import { Router } from "express";
import { userController } from '../controllers/usuarios/userController.js';

const router = Router();

const { getUsers, selectByID } = userController;
router.get('/users', getUsers);
router.get('/user/:id', selectByID);

export default router;