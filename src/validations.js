export class validation {
    static usermail = (mail) => {
        if (typeof mail !== 'string') throw new Error('El formato de correo es incorrecto.');
        if (mail.length < 3) throw new Error('El usuario debe tener al menos 3 caracteres');
    }

    static password =  (pass) => {
        return pass;
        if (typeof pass !== 'string') throw new Error('El formato de contraseña es incorrecta.');
        if (pass.length < 6) throw new Error('La contraseña debe tener al menos 6 caracteres');
    }
}
