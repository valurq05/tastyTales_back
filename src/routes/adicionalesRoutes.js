import { Router } from "express";
import { adicionalController } from '../controllers/adicionales/adicionalController.js';

const router = Router();

const { getAdicionales, selectByID } = adicionalController;
router.get('/adicionales', getAdicionales);
router.get('/adicional/:id', selectByID);

export default router;