package com.ucav.gestionProtocoloService.utils;

import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.codec.binary.Base64;

public class ZipUitls {

    public static String createZipB64(byte[] data, String name) {
        if (data == null || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Los parámetros 'data' y 'name' no pueden ser nulos o vacíos");
        }

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ZipOutputStream zos = new ZipOutputStream(baos)) {

            // Crear una nueva entrada ZIP
            ZipEntry entry = new ZipEntry(name);
            zos.putNextEntry(entry);

            // Escribir los datos en la entrada ZIP
            zos.write(data);
            zos.closeEntry();

            // Cerrar el ZipOutputStream para finalizar el archivo ZIP
            zos.close();

            // Codificar el ZIP en Base64
            return Base64.encodeBase64String(baos.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear el archivo ZIP codificado en Base64", e);
        }
    }

}
