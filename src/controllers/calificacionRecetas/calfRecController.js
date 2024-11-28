import { DAOCalfRec } from './DAOCalfRec.js';

export class calfRecController {
    static getCalfRec = async (req, res) => {
        try {
            const { user } = req.session;
            // return res.json({ user });
            if (!user) return res.status(401).json({ message: 'No autorizado' });
            const data = await DAOCalfRec.selectAll();
            return res.status(200).json(data);
        } catch (e) {
            return res.status(400).json(e);
        }
    }

    static selectByID = async (req, res) => {
        try {
            const { user } = req.session;
            const { id } = req.body;
            if (!user) return res.status(401).json({ user: null });
            const data = await DAOCalfRec.selectByID(id);
            return res.status(200).json(data);
        } catch (e) {
            return res.status(400).json(e);
        }
    }
}