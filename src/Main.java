//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner sc = new Scanner(System.in);
    ArrayList<Contacto> contactos = new ArrayList<>();
    System.out.println("AGENDA DE CONTACTOS\n===================");
    boolean continuar = true;
    while (continuar) {
        System.out.println("1. Agregar contacto");
        System.out.println("2. Mostrar todos los contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Salir");

        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                System.out.println("Ingresa el nombre del contacto: ");
                String nombre =  sc.next();

                System.out.println("Ingresa el teléfono del contacto: ");
                int telefono =  sc.nextInt();

                Contacto contacto = new Contacto(nombre, telefono);
                contactos.add(contacto);
            }
            case 2 -> {
                boolean existe = false;
                for(Contacto contacto : contactos) {
                    System.out.println(contacto);
                    existe = true;
                }
                if(!existe) System.out.println("No hay contactos en la agenda");
            }
            case 3 -> {
                boolean encontrado = false;
                System.out.println("Ingresa el nombre del contacto: ");
                String nombre =  sc.next();
                System.out.println("Ingresa el teléfono del contacto: ");
                int telefono =  sc.nextInt();
                for(Contacto contacto : contactos) {
                    if(contacto.getNombre().equals(nombre) &&  contacto.getTelefono() == telefono) {
                        System.out.println("Se ha encontrado al contacto" + contacto);
                        encontrado = true;
                    }
                }
                if(!encontrado) System.out.println("No se ha encontrado ningún contacto de nombre "+nombre+" y teléfono "+telefono);
            }
            case 4 -> {
                System.out.println("Ingresa el nombre del contacto: ");
                String nombre =  sc.next();
                System.out.println("Ingresa el teléfono del contacto: ");
                int telefono =  sc.nextInt();
                for(int i=0; i<contactos.size();i++) {
                    if (contactos.get(i).getNombre().equals(nombre) && contactos.get(i).getTelefono() == telefono) {
                        contactos.remove(i);
                        System.out.println("Contacto eliminado");
                    }
                }
            }
            case 5 -> continuar = false;
        }
    }
    System.out.println("Saliendo de la aplicación...");
}