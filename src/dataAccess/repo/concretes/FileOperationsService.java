package dataAccess.repo.concretes;

import dataAccess.repo.abstracts.FileOperations;
import entity.order.Product;
import entity.user.Seller;

import java.io.*;

public class FileOperationsService implements FileOperations {

    @Override
    public void getAll(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeToFile(String text, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(text+";");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id, String fileName) {
        File inputFile = new File(fileName);
        File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

            String line;
            boolean deleted = false;

            while ((line = reader.readLine()) != null) {
                String[] datas = line.split(";");
                boolean skipLine = false;

                for (String data : datas) {
                    String[] parts = data.split(",");
                    if (parts[0].equals(id.toString())) {
                        skipLine = true;
                        deleted = true;
                        break; // Bu satırı atla, yani yazma
                    }
                }

                if (!skipLine) {
                    writer.println(line);
                }
            }

            if (deleted) {
                if (!inputFile.delete()) {
                    System.out.println("Could not delete file");
                    return;
                }
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("Could not rename file");
                }
            } else {
                tempFile.delete(); // Geçici dosyayı sil
                System.out.println("ID not found");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(Integer id, String fileName,String info) throws IOException {
        File inputFile = new File(fileName);
        File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

            String line;
            boolean updated = false;

            while ((line = reader.readLine()) != null) {
                String[] datas = line.split(";");
                boolean updatedLine = false;

                for (String data : datas) {
                    String[] parts = data.split(",");
                    if (parts[0].equals(id.toString())) {
                        writer.println(info); // Güncellenmiş veriyi yaz
                        updated = true;
                        updatedLine = true;
                        break;
                    }
                }

                if (!updatedLine) {
                    writer.println(line);
                }
            }

            if (updated) {
                if (!inputFile.delete()) {
                    System.out.println("Could not delete file");
                    return;
                }
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("Could not rename file");
                }
            } else {
                tempFile.delete(); // Geçici dosyayı sil
                System.out.println("ID not found");
            }

        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public void getById(Integer id, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datas = line.split(";");
                for (String data : datas) {
                    String[] parts = data.split(",");
                    if (parts[0].equals(id.toString())) {
                        System.out.println(line);
                        return; // ID bulundu, satırı döndür
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ID not found"); // ID bulunamadıysa
    }

    @Override
    public void getAllProductsByProductName(Product product, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datas = line.split(";");
                for (String data : datas) {
                    String[] parts = data.split(",");
                    if (parts[1].equals(product.getProductName())) {
                        System.out.println(line);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAllProductsByCategory(Product product, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datas = line.split(";");
                for (String data : datas) {
                    String[] parts = data.split(",");
                    if (parts[2].equals(product.getCategory())) {
                        System.out.println(line);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAllProductsLessThanPrice(Product product, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datas = line.split(";");
                for (String data : datas) {
                    String[] parts = data.split(",");
                    if (Double.parseDouble(parts[3]) < product.getUnitPrice()) {
                        System.out.println(line);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAllProductsGreaterThanPrice(Product product, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datas = line.split(";");
                for (String data : datas) {
                    String[] parts = data.split(",");
                    if (Double.parseDouble(parts[3]) > product.getUnitPrice()) {
                        System.out.println(line);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getSellerByStoreName(String storeName, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datas = line.split(";");
                for (String data : datas) {
                    String[] parts = data.split(",");
                    if (parts[1].equals(storeName)) {
                        System.out.println(line);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
