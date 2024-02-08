package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Integer nivelVida=70;
        Integer contadorSkills=0;
        Integer contadorDisparos=0;
        Integer precioSkill=100000;
        Integer danoDisparos=-5;
        String nickName;
        String nickNameBD="danielpuertam";
        String contrasena;
        String contrasenaBD="barcelona1013";
        String[] juegos={"free fire","fifa 24"};
        String juegoSeleccionado;
        boolean estaMuerto=false;

        // cada skill de vida asigna 10 de vida a $100.0000, maximo 5 skills de vida
        // cada vez que me disparan genera un daño de 5 unidades de vida
        // si en una partida entra más de 3 disparos seguidos muero
        // ingresando y despues de 3 segundos me salga

        System.out.println("ingresando.....................");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException exepcion){
            exepcion.printStackTrace();
            System.out.println("error de ejecucion ");
        }
        System.out.println("Bienvenido----------------------");
        System.out.print("ingrese el nombre del personaje: ");
        nickName=sc.nextLine();
        System.out.print("ingrese la contraseña con la que está registrado: "+nickName+" ");
        contrasena=sc.nextLine();
        if (contrasena.equals(contrasenaBD) && nickName.equals(nickNameBD)){
            System.out.println("contraseña correcta");
            System.out.println("seleccione un juego: ");
            juegoSeleccionado=sc.nextLine();
            if (juegoSeleccionado.equalsIgnoreCase(juegos[0])){
                System.out.println("bienvenido a free fire ");
                //random para disparar o no
                do {
                    Random random=new Random();
                    boolean disparo= random.nextBoolean();
                    if (disparo){
                        System.out.println("te dispararon");
                        nivelVida+=danoDisparos;
                        contadorDisparos++;
                        System.out.println("tu vida restante es de: "+nivelVida);

                    }else {
                        System.out.println("esquivaste la bala ");
                        contadorDisparos=0;
                    }
                    System.out.println("desea seguir jugando? si/no ");
                    String respueta= sc.nextLine();
                    if (nivelVida==0 || contadorDisparos==3 || respueta.equals("no")){
                        estaMuerto=true;
                    }else {
                        estaMuerto=false;
                        continue;
                    }
                }while (estaMuerto==false);
                System.out.println("juego terminado");



            }else if (juegoSeleccionado.equals(juegos[1])){
                System.out.println("servidores no disponibles para: "+juegos[1]);
            }else {
                System.out.println("error de seleccion");
            }
        }else{
            System.out.println("contraseña incorrecta vuelva a entrar");
        }


    }
}