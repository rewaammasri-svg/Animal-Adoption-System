package javaappanimal;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdoptionGUI {

    private Stage stage;
    private BorderPane root;
    private ListView<Animal> animalList;
    private ListView<Adopter> adopterList;

    public AdoptionGUI(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        root = new BorderPane();

        Label title = new Label("Animal Adoption System");
        title.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");

        VBox menu = new VBox(12);
        menu.setPadding(new Insets(20));
        menu.setPrefWidth(220);
        menu.setStyle("-fx-background-color: #2c3e50;");

        Button addAnimalBtn = menuButton("Add Animal");
        Button addAdopterBtn = menuButton("Add Adopter");
        Button adoptBtn = menuButton("Adopt Animal");
        Button viewBtn = menuButton("View Records");
        Button reportBtn = menuButton("Reports");
        Button exitBtn = menuButton("Exit");

        menu.getChildren().addAll(addAnimalBtn, addAdopterBtn, adoptBtn, viewBtn, reportBtn, exitBtn);

        HBox top = new HBox(title);
        top.setPadding(new Insets(15));
        top.setAlignment(Pos.CENTER);
        top.setStyle("-fx-background-color: #ecf0f1;");

        root.setLeft(menu);
        root.setTop(top);
        root.setCenter(homePage());

        addAnimalBtn.setOnAction(e -> root.setCenter(addAnimalPage()));
        addAdopterBtn.setOnAction(e -> root.setCenter(addAdopterPage()));
        adoptBtn.setOnAction(e -> root.setCenter(adoptionPage()));
        viewBtn.setOnAction(e -> root.setCenter(viewRecordsPage()));
        reportBtn.setOnAction(e -> root.setCenter(reportsPage()));
        exitBtn.setOnAction(e -> {
            Main.saveData();
            stage.close();
        });

        Scene scene = new Scene(root, 1000, 650);
        stage.setTitle("Animal Adoption System");
        stage.setScene(scene);
        stage.show();
    }

    private Button menuButton(String text) {
        Button btn = new Button(text);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setStyle("-fx-font-size: 15px; -fx-background-color: #34495e; -fx-text-fill: white;");
        return btn;
    }

    private VBox homePage() {
        VBox box = pageBox();

        Label welcome = new Label("Welcome to Animal Adoption System");
        welcome.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label info = new Label("Use the main menu to manage animals, adopters, adoptions, and reports.");
        info.setStyle("-fx-font-size: 16px;");

        box.getChildren().addAll(welcome, info);
        return box;
    }

    private VBox addAnimalPage() {
        VBox box = pageBox();

        ComboBox<String> type = new ComboBox<>();
        type.getItems().addAll("Dog", "Cat", "Bird");
        type.setPromptText("Animal Type");

        TextField id = field("Animal ID");
        TextField name = field("Animal Name");
        TextField age = field("Age");
        ComboBox<String> gender = new ComboBox<>();
        gender.getItems().addAll("Male", "Female");
        gender.setPromptText("Gender");
        
        Button save = new Button("Save Animal");

        save.setOnAction(e -> {
            
            if (type.getValue() == null ||id.getText().trim().isEmpty() || name.getText().trim().isEmpty() ||
                age.getText().trim().isEmpty() || gender.getValue() == null) {
                message("Please fill all fields.");
               return; 
            }
            String animalId = id.getText().trim();
           if (Main.searchAnimalById(animalId) != null) {
            message("Animal ID already exists.");
            return;
           }
            
           try {
                int animalAge = Integer.parseInt(age.getText().trim());

                if (animalAge <= 0) {
                message("Age must be greater than 0.");
                return;
                }

                Animal animal = null;
                
                if (type.getValue().equals("Dog")) {
                    animal = new Dog(id.getText(), name.getText(),animalAge, gender.getValue(), false);
                } else if (type.getValue().equals("Cat")) {
                    animal = new Cat(id.getText(), name.getText(), Integer.parseInt(age.getText()), gender.getValue(),false);
                } else if (type.getValue().equals("Bird")) {
                    animal = new Bird(id.getText(), name.getText(), Integer.parseInt(age.getText()), gender.getValue(), false);
                }

                Main.addAnimal(animal);
                message("Animal added successfully.");

                id.clear();
                name.clear();
                age.clear();
                gender.setValue(null);                
                type.setValue(null);

            } catch (Exception ex) {
                message("Please enter valid animal data.");
            }
        });

        box.getChildren().addAll(title("Add Animal"), type, id, name, age, gender, save);
        return box;
    }

    private VBox addAdopterPage() {
        VBox box = pageBox();

        TextField id = field("Adopter ID");
        TextField name = field("Adopter Name");
        TextField phone = field("Phone");
        TextField address = field("Address");

        Button save = new Button("Save Adopter");

        save.setOnAction(e -> {
            
            if (id.getText().trim().isEmpty()
                    || name.getText().trim().isEmpty()
                    || phone.getText().trim().isEmpty()
                    || address.getText().trim().isEmpty()) {

                message("Please fill all fields.");
                return;
            }

            String adopterId = id.getText().trim();

            if (Main.searchAdopterById(adopterId) != null) {
                message("Adopter ID already exists.");
                return;
            }
            Adopter adopter = new Adopter(id.getText(), name.getText(), phone.getText(), address.getText());
            Main.addAdopter(adopter);
            message("Adopter added successfully.");

            id.clear();
            name.clear();
            phone.clear();
            address.clear();
        });

        box.getChildren().addAll(title("Add Adopter"), id, name, phone, address, save);
        return box;
    }

    private VBox adoptionPage() {
        VBox box = pageBox();

        TextField animalId = field("Animal ID");
        TextField adopterId = field("Adopter ID");

        Button adopt = new Button("Complete Adoption");

        adopt.setOnAction(e -> {
            boolean result = Main.adoptAnimal(animalId.getText(), adopterId.getText());

            if (result) {
                message("Adoption completed successfully.");
            } else {
                message("Adoption failed. Check IDs or animal status.");
            }
            animalId.clear();
            adopterId.clear();
        });

        box.getChildren().addAll(title("Adopt Animal"), animalId, adopterId, adopt);
        return box;
    }
    private VBox viewRecordsPage() {
        VBox box = pageBox();

        animalList = new ListView<>();
        adopterList = new ListView<>();

        animalList.setItems(FXCollections.observableArrayList(Main.getAnimals()));
        adopterList.setItems(FXCollections.observableArrayList(Main.getAdopters()));

        HBox lists = new HBox(20,
                new VBox(5, title("Animals"), animalList),
                new VBox(5, title("Adopters"), adopterList));

        box.getChildren().addAll(title("View Records"), lists);
        return box;
    }

    private VBox reportsPage() {
        VBox box = pageBox();

        int totalAnimals = Main.getAnimals().size();
        int availableAnimals = Main.getAvailableAnimals().size();
        int adoptedAnimals = totalAnimals - availableAnimals;
        int totalAdopters = Main.getAdopters().size();
        int totalAdoptions = Main.getAdoptions().size();

        Label report = new Label(
                "Total Animals: " + totalAnimals +
                "\nAvailable Animals: " + availableAnimals +
                "\nAdopted Animals: " + adoptedAnimals +
                "\nTotal Adopters: " + totalAdopters +
                "\nTotal Adoptions: " + totalAdoptions );

        report.setStyle("-fx-font-size: 18px;");
        box.getChildren().addAll(title("System Reports"), report);
        return box;
    }

    private TextField field(String prompt) {
        TextField tf = new TextField();
        tf.setPromptText(prompt);
        tf.setMaxWidth(300);
        return tf;
    }

    private Label title(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        return label;
    }

    private VBox pageBox() {
        VBox box = new VBox(12);
        box.setPadding(new Insets(25));
        box.setAlignment(Pos.TOP_LEFT);
        return box;
    }

    private void message(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
