Instalar o Java e a IDE escolhida (Intelij)
    - Verificar se a library " jre system library" está na mesma versão do java
        Eclipse, File | Project Structure | Project Settings | Modules.
Em https://mvnrepository.com/, buscar por rest assured
    - Criar as dependencias no pom.xml
    - ex:   <dependencies>
                <dependency>
                    <groupId>io.rest-assured</groupId>
                    <artifactId>rest-assured</artifactId>
                    <version>4.0.0</version>
                </dependency>
            </dependencies>
    - Verificar se foi criada em Maven/project/dependencies