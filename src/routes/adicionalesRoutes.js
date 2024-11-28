import { Router } from "express";
import { adicionalController } from '../controllers/adicionales/adicionalController.js';

const router = Router();

const { getAdicionales, selectByID, postAdicional } = adicionalController;
router.get('/adicionales', getAdicionales);
router.get('/adicional/:id', selectByID);
router.post('/adicional', postAdicional);

export default router;