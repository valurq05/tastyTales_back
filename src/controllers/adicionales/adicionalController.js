import { DAOAdicionales } from './DAOAdicionales.js';

export class adicionalController {
    static getAdicionales = async (req, res) => {
        try {
            const { user } = req.session;
            // return res.json({ user });
            if (!user) return res.status(401).json({ message: 'No autorizado' });
            const data = await DAOAdicionales.selectAll();
            return res.status(200).json(data);
        } catch (e) {
            return res.status(400).json(e);
        }
    }

    static selectByID = async (req, res) => {
        try {
            const { user } = req.session;
            if (!user) return res.status(401).json({ user: null });
            const data = await DAOAdicionales.selectByID(user.userID);
            return res.status(200).json(data);
        } catch (e) {
            return res.status(400).json(e);
        }
    }
}