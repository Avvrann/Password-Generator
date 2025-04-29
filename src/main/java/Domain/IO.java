package Domain;

import java.io.File;
import java.io.FileWriter;

public class IO {
    KeyGenerator password = new KeyGenerator ();

    //crear el archivo para guardar las contrasenas
    public void createTxtPasswords(){
        try {
            //creando el archivo .txt
            File txtPasswords = new File(
                    "/home/avrann/Escritorio/KeyGen/PassWordGenerator/src/main/resources/PathPasswords/vaultPassword.txt");

            //NOTA: el metodo createNewFile() se encarga de crear nuestro archivo develve un valor booleano false si el
            //archivo ya existe.
            if (txtPasswords.createNewFile()){
                System.out.println("archivo creado");
            }else {
                System.out.println("exite un archivo en la ruta especificada");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    //crear el metodo para guardar las contrasenas
    public void writeInVaultPasswords(){
        try {
            FileWriter writer = new FileWriter(
                    "/home/avrann/Escritorio/KeyGen/PassWordGenerator/src/main/resources/PathPassowrds/vaultPassword.txt");
            writer.write(password.generatePassword());
            writer.close();

        }catch (Exception e){
            System.out.println("no se puede escribir sobre este archivo");
        }
    }
}
