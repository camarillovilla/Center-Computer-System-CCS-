package gui;

import businesslogic.DevolucionDAO;
import businesslogic.DispositivoDAO;
import businesslogic.JefeCentroComputoDAO;
import businesslogic.PrestamoDAO;
import businesslogic.ResponsableDAO;
import domain.Cable;
import domain.Conector;
import domain.Control;
import domain.Devolucion;
import domain.Dispositivo;
import domain.Laptop;
import domain.Prestamo;
import domain.Prestatario;
import domain.PrestatarioDAO;
import domain.Proyector;
import domain.Responsable;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * 
 * @author daniCV
 */

public class ControladorInicio implements Initializable {
    private final JefeCentroComputoDAO  jefeCentroComputoDAO = new JefeCentroComputoDAO();
    private final ResponsableDAO responsableDAO = new ResponsableDAO();
    private final DispositivoDAO dispositivoDAO = new DispositivoDAO();
    private final PrestatarioDAO prestatarioDAO = new PrestatarioDAO();
    private final PrestamoDAO prestamoDAO = new PrestamoDAO();
    private final DevolucionDAO devolucionDAO = new DevolucionDAO();
    
    @FXML 
    private AnchorPane anchorPaneInicioSesion;
    @FXML
    private AnchorPane anchorPaneWhiteInicio;
    @FXML
    private AnchorPane anchorPaneMenuLateral;
    @FXML
    private AnchorPane anchorPaneRegistroDeResponsable;    
    @FXML
    private AnchorPane anchorPaneRegistroDeDispositivo;   
    @FXML
    private AnchorPane anchorPaneBuscarDispositivo;   
    @FXML
    private AnchorPane anchorPaneDevolucionDispositivo;    
    @FXML
    private AnchorPane anchorPaneRegistroMantenimiento;    
    @FXML
    private AnchorPane anchorPaneReporteVerficacion;  
    @FXML
    private AnchorPane anchorPaneCaractetisticasDispositivo;
    @FXML
    private AnchorPane anchorPanePrestamoDispositivo;
    @FXML 
    private Button buttonRegistrarResponsable;
    @FXML 
    private Button buttonRegistrarDispositivo;
    @FXML
    private ComboBox<String> comboBoxTurnoRegistroResponsable;    
    @FXML 
    private ComboBox<String> comboBoxEstatusRegistroDispositivo;    
    @FXML
    private ComboBox<String> comboBoxCategoriaRegistroDispositivo;    
    @FXML
    private ComboBox<String> comboBoxFiltroBusqueda;   
    @FXML
    private ComboBox<String> comboBoxPrestamoTipoPrestatario;
    @FXML
    private ComboBox<String> comboBoxDevolucionClaveDispositivo;
    @FXML 
    private DatePicker dataPickerFechaRegistroDispositivo;    
    @FXML 
    private DatePicker datePickerPrestamoFecha;
    @FXML 
    private DatePicker datePickerReporteFechaBusqueda;
    @FXML 
    private DatePicker datePickerDevolucionFecha;
    @FXML
    private ImageView imageViewBackMenuLateral;
    @FXML
    private ImageView imageViewMenuLateral;    
    @FXML
    private ImageView imageViewRegistraResponsable;   
    @FXML
    private ImageView imageViewRegistrarDispositivoLaptop;
    @FXML
    private ImageView imageViewRegistrarDispositivoMas;
    @FXML
    private ImageView imageViewRegistrarDispositivoProyector;
    @FXML
    private ImageView imageViewRegistrarDispositivoCable;
    @FXML
    private ImageView imageViewRegistrarDispositivoCirculo;
    @FXML
    private ImageView imageViewBuscarDispositivo;
    @FXML
    private ImageView imageViewDevolucion;
    @FXML
    private ImageView imageViewMantenimiento;
    @FXML
    private ImageView imageViewReporte;    
    @FXML
    private Label labelContrasenasIguales;    
    @FXML
    private Label labelLugarProyectorRegistroDispositivo;    
    @FXML
    private Label labelCamposInvalidosInicioSesion;
    @FXML
    private Label labelUsuarioInicioSesion;
    @FXML
    private Label labelContrasenaInicioSesion;
    @FXML
    private Label labelClaveProyectorRegistroDispositivo;
    @FXML
    private MenuButton labelNombreUsuarioCargado;
    @FXML
    private PasswordField passwordFieldContrasenaRegistroResponsable;
    @FXML
    private PasswordField passwordFieldConfirmacionContrasenaRegistroResponsable;
    @FXML
    private PasswordField passwordFielContrasenaInicioSesion;
    @FXML
    private TextField textFieldNumeroRegistroResponsable;
    @FXML
    private TextField textFieldNombeRegistroResponsable;
    @FXML
    private TextField textFieldClaveRegistroDispositivo;        
    @FXML
    private TextField textFieldDescripcionRegistroDispositivo;
    @FXML
    private TextField textFieldLugarProyectorRegistroDispositivo;
    @FXML
    private TextField textFieldUsuarioInicioSesion;
    @FXML
    private TextField textFieldClaveProyectorRegistroDispositivo;
    @FXML
    private TextField textFieldPrestamoClaveDispositivo;
    @FXML
    private TextField textFieldPrestamoLugarDispositivo;
    @FXML
    private TextField textFieldPrestamoNombrePrestatario;
    @FXML
    private TextField textFieldPrestamoClavePrestatario;
    @FXML
    private TableView<Cable> tableViewBusquedaCable;
    @FXML
    private TableColumn tableColumnBusquedaClaveCable;
    @FXML
    private TableColumn tableColumnBusquedaDescripcionCable;
    @FXML
    private TableColumn tableColumnBusquedaFechaCable;
    @FXML
    private TableColumn tableColumnBusquedaEstatusCable;
    @FXML
    private TableView<Conector> tableViewBusquedaConector;
    @FXML
    private TableColumn tableColumnBusquedaClaveConector;
    @FXML
    private TableColumn tableColumnBusquedaDescripcionConector;
    @FXML
    private TableColumn tableColumnBusquedaFechaConector;
    @FXML
    private TableColumn tableColumnBusquedaEstatusConector;
    @FXML
    private TableView<Control> tableViewBusquedaControl;
    @FXML
    private TableColumn tableColumnBusquedaClaveControl;
    @FXML
    private TableColumn tableColumnBusquedaDescripcionControl;
    @FXML
    private TableColumn tableColumnBusquedaFechaControl;
    @FXML
    private TableColumn tableColumnBusquedaEstatusControl;
    @FXML
    private TableColumn tableColumBusquedaLugarProyectorControl;
    @FXML
    private TableColumn tableColumBusquedaClaveProyectorControl;
    @FXML
    private TableView<Laptop> tableViewBusquedaLaptop;
    @FXML
    private TableColumn tableColumnBusquedaClaveLaptop;
    @FXML
    private TableColumn tableColumnBusquedaDescripcionLaptop;
    @FXML
    private TableColumn tableColumnBusquedaFechaLaptop;
    @FXML
    private TableColumn tableColumnBusquedaEstatusLaptop;
    @FXML
    private TableView<Proyector> tableViewBusquedaProyector;
    @FXML
    private TableColumn tableColumnBusquedaClaveProyector;
    @FXML
    private TableColumn tableColumnBusquedaDescripcionProyector;
    @FXML
    private TableColumn tableColumnBusquedaFechaProyector;
    @FXML
    private TableColumn tableColumnBusquedaEstatusProyector;   
    @FXML
    private TableView<Dispositivo> tableViewBusquedaDispositivo;
    @FXML
    private TableColumn tableColumnBusquedaClaveDispositivo;
    @FXML
    private TableColumn tableColumnBusquedaDescripcionDispositivo;
    @FXML
    private TableColumn tableColumnBusquedaFechaDispositivo;
    @FXML
    private TableColumn tableColumnBusquedaEstatusDispositivo;
    @FXML
    private TableView<Cable> tableViewCaracteristicasCable;
    @FXML
    private TableColumn tableColumnCaracteristicasClaveCable;
    @FXML
    private TableColumn tableColumnCaracteristicasDescripcionCable;
    @FXML
    private TableColumn tableColumnCaracteristicasFechaCable;
    @FXML
    private TableColumn tableColumnCaracteristicasEstatusCable;
    @FXML
    private TableView<Conector> tableViewCaracteristicasConector;
    @FXML
    private TableColumn tableColumnCaracteristicasClaveConector;
    @FXML
    private TableColumn tableColumnCaracteristicasDescripcionConector;
    @FXML
    private TableColumn tableColumnCaracteristicasFechaConector;
    @FXML
    private TableColumn tableColumnCaracteristicasEstatusConector;
    @FXML
    private TableView<Laptop> tableViewCaracteristicasLaptop;
    @FXML
    private TableColumn tableColumnCaracteristicasClaveLaptop;
    @FXML
    private TableColumn tableColumnCaracteristicasDescripcionLaptop;
    @FXML
    private TableColumn tableColumnCaracteristicasFechaLaptop;
    @FXML
    private TableColumn tableColumnCaracteristicasEstatusLaptop;
    @FXML
    private TableView<Proyector> tableViewCaracteristicasProyector;
    @FXML
    private TableColumn tableColumnCaracteristicasClaveProyector;
    @FXML
    private TableColumn tableColumnCaracteristicasDescripcionProyector;
    @FXML
    private TableColumn tableColumnCaracteristicasFechaProyector;
    @FXML
    private TableColumn tableColumnCaracteristicasEstatusProyector;  
    @FXML
    private TableView<Control> tableViewCaracteristicasControl;
    @FXML
    private TableColumn tableColumnCaracteristicasClaveControl;
    @FXML
    private TableColumn tableColumnCaracteristicasDescripcionControl;
    @FXML
    private TableColumn tableColumnCaracteristicasFechaControl;
    @FXML
    private TableColumn tableColumnCaracteristicasEstatusControl;
    @FXML
    private TableColumn tableColumnCaracteristicasLugarControl;
    @FXML
    private TableColumn tableColumnCaracteristicasClaveProyectorControl;
    @FXML
    private TableView<Prestamo> tableViewReportePrestamos;
    @FXML
    private TableColumn tableColumnReporteClave;
    @FXML
    private TableColumn tableColumnReporteFecha;
    @FXML
    private TableColumn tableColumnReporteLugar;
    @FXML
    private TableColumn tableColumnReporteResponsable;
    @FXML
    private TableColumn tableColumnReportePrestatario;
    @FXML
    private TableView<Devolucion> tableViewDevoluciones;
    @FXML
    private TableColumn tableColumnDevolucionesClave;
    @FXML
    private TableColumn tableColumnDevolucionesFecha;
    @FXML
    private TableColumn tableColumnDevolucionesResponsable;
    @FXML
    private TableColumn tableColumnDevolucionesPrestatario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainMenuLateral();
        llenarComboBoxTurnoRegistroResponsable();
        llenarComboBoxCategoriaRegistroDispositivo();
        llenarComboBoxEstatusRegistroDispositivo();
        validarCampos();
    }
    
    public void mostrarCamposInvalidosInicioSesion(CamposInvalidosInicioSesion camposInvalidosInicioSesion) { 
        if (!camposInvalidosInicioSesion.getNombreUsuarioValido() && camposInvalidosInicioSesion.getContrasenaUsuarioValida()) {
            labelCamposInvalidosInicioSesion.setText("Nombre es requerido");
            labelCamposInvalidosInicioSesion.setVisible(true);
        } 
        
        if (!camposInvalidosInicioSesion.getContrasenaUsuarioValida() && camposInvalidosInicioSesion.getNombreUsuarioValido()) {
            labelCamposInvalidosInicioSesion.setText("Contraseña es requerida");
            labelCamposInvalidosInicioSesion.setVisible(true);
        }
        
        if (!camposInvalidosInicioSesion.getNombreUsuarioValido() && !camposInvalidosInicioSesion.getContrasenaUsuarioValida()) {
            labelCamposInvalidosInicioSesion.setText("Campos son requeridos");
            labelCamposInvalidosInicioSesion.setVisible(true);
        }
        
        if (!camposInvalidosInicioSesion.getUsuarioEncontrado() && camposInvalidosInicioSesion.getContrasenaUsuarioValida() && camposInvalidosInicioSesion.getNombreUsuarioValido()) {
            labelCamposInvalidosInicioSesion.setText("Sin coincidencias"); 
            labelCamposInvalidosInicioSesion.setVisible(true);
        } 
    }
    
    @FXML
    public void iniciarSesion(ActionEvent actionEvent) {        
        String nombreCompletoUsuario = null;
        String contrasenaUsuario = null;
        String nombreUsuarioEsperado = null;
        String contrasenaUsuarioEsperada = null;
                
        boolean nombreUsuarioValido = false; 
        boolean contrasenaUsuarioValida = false;
        boolean usuarioEncontrado = false;

        if (!textFieldUsuarioInicioSesion.getText().isEmpty()) {
            nombreCompletoUsuario = textFieldUsuarioInicioSesion.getText();
            nombreUsuarioValido = true;
        }
        if (!passwordFielContrasenaInicioSesion.getText().isEmpty()) {
            contrasenaUsuario = passwordFielContrasenaInicioSesion.getText();
            contrasenaUsuarioValida = true;
        }
        
        for (int i = 0; i < jefeCentroComputoDAO.consultarListaDeJefesCentroComputo().size(); i++) {
            nombreUsuarioEsperado = jefeCentroComputoDAO.consultarListaDeJefesCentroComputo().get(i).getNombreCompleto();
            contrasenaUsuarioEsperada = jefeCentroComputoDAO.consultarListaDeJefesCentroComputo().get(i).getContrasena();
            if (nombreUsuarioEsperado.equals(nombreCompletoUsuario) && contrasenaUsuarioEsperada.equals(contrasenaUsuario)) {
                usuarioEncontrado = true; 
            }
        }
        for (int i = 0; i < responsableDAO.consultarListaDeResponsables().size(); i++) {
            nombreUsuarioEsperado = responsableDAO.consultarListaDeResponsables().get(i).getNombreCompleto();
            contrasenaUsuarioEsperada = responsableDAO.consultarListaDeResponsables().get(i).getContrasena();
            if (nombreUsuarioEsperado.equals(nombreCompletoUsuario) && contrasenaUsuarioEsperada.equals(contrasenaUsuario)) {
                usuarioEncontrado = true; 
            }
        }
        CamposInvalidosInicioSesion camposInvalidosInicioSesion = new CamposInvalidosInicioSesion(nombreUsuarioValido, contrasenaUsuarioValida, usuarioEncontrado);
        mostrarCamposInvalidosInicioSesion(camposInvalidosInicioSesion);
        
        if (nombreUsuarioValido && contrasenaUsuarioValida && usuarioEncontrado) {  
            anchorPaneInicioSesion.setVisible(false);
            labelNombreUsuarioCargado.setText(nombreCompletoUsuario);
            tipoUsuarioCargado(nombreCompletoUsuario);
            prioridadesUsuario(tipoUsuarioCargado(nombreCompletoUsuario));
        } 
    }
    
    public String tipoUsuarioCargado(String nombreUsuario) {
        boolean esJefe = false;
        boolean esResponsable = false;
        
        for (int i = 0; i < jefeCentroComputoDAO.consultarListaDeJefesCentroComputo().size(); i++) {
            String nombreEsperado = jefeCentroComputoDAO.consultarListaDeJefesCentroComputo().get(i).getNombreCompleto();
            if (nombreUsuario.equals(nombreEsperado)) {
                esJefe = true; 
            }
        }
        
        for (int i = 0; i < responsableDAO.consultarListaDeResponsables().size(); i++) {
            String nombreEsperado = responsableDAO.consultarListaDeResponsables().get(i).getNombreCompleto();
            if (nombreUsuario.equals(nombreEsperado)) {
                esResponsable = true; 
            }
        }
        String cargo = null;
        if (esJefe) {
            cargo = "Jefe";
        } 
        if (esResponsable) {
            cargo = "Responsable";
        }
        if (esJefe && esResponsable) {
            cargo = "Ambos";
        }
        return cargo;
    }
    
    public void prioridadesUsuario(String cargo) {
        String responsable = "Responsable";
        if (responsable.equals(cargo)) {
            buttonRegistrarResponsable.setDisable(true);
            imageViewRegistraResponsable.setOpacity(0.5);
            imageViewRegistraResponsable.setDisable(true);
            buttonRegistrarDispositivo.setDisable(true);
            imageViewRegistrarDispositivoLaptop.setOpacity(0.5);
            imageViewRegistrarDispositivoMas.setOpacity(0.5);
            imageViewRegistrarDispositivoProyector.setOpacity(0.5);
            imageViewRegistrarDispositivoCable.setOpacity(0.5);
            imageViewRegistrarDispositivoCirculo.setOpacity(0.5);
            imageViewRegistrarDispositivoLaptop.setDisable(true);
            imageViewRegistrarDispositivoMas.setDisable(true);
            imageViewRegistrarDispositivoProyector.setDisable(true);
            imageViewRegistrarDispositivoCable.setDisable(true);
            imageViewRegistrarDispositivoCirculo.setDisable(true);
            datePickerReporteFechaBusqueda.setDisable(true);
        }
    }
    
    @FXML
    public void efectoHoverInicioSesion() {
        textFieldUsuarioInicioSesion.setOnMouseEntered((MouseEvent event1) -> {
            labelUsuarioInicioSesion.setVisible(true);
        });
          
        textFieldUsuarioInicioSesion.setOnMouseExited((MouseEvent event1) -> {
            if (textFieldUsuarioInicioSesion.getText().isEmpty()) {
               labelUsuarioInicioSesion.setVisible(false);
            }
        }); 
        
        passwordFielContrasenaInicioSesion.setOnMouseEntered((MouseEvent event) -> {
            labelContrasenaInicioSesion.setVisible(true);
        });
        
        passwordFielContrasenaInicioSesion.setOnMouseExited((MouseEvent event1) -> {
            if (passwordFielContrasenaInicioSesion.getText().isEmpty()) {
               labelContrasenaInicioSesion.setVisible(false);
            }
        }); 
    }
    
    EventHandler<KeyEvent> handlerLetters = new EventHandler<KeyEvent>() {
        private boolean willConsume = false;
        @Override
        public void handle(KeyEvent event) {
            Object temp0 = event.getSource();
            if (willConsume) {
                event.consume();
            }
            String temp = event.getCode().toString();
            if (!event.getCode().toString().matches("[a-zA-Z]") && event.getCode() != KeyCode.BACK_SPACE && event.getCode() != KeyCode.SHIFT && event.getCode() != KeyCode.SPACE) {
                if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    willConsume = true;
                } else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                        willConsume = false; 
                }
            }
        }
    };
    
    EventHandler<KeyEvent> handlerNumbers = new EventHandler<KeyEvent>() {
        private boolean willConsume = false;
        private int maxLength = 12;
        @Override
        public void handle(KeyEvent event) {
            TextField temp = (TextField) event.getSource();
            if (willConsume) {
                event.consume();
            }
            if (!event.getText().matches("[0-9]") && event.getCode() != KeyCode.BACK_SPACE) {
                if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    willConsume = true;
                } else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                        willConsume = false; 
                }
            }
        }
    };
    
    public LocalDate convertToLocalDate(Date date) {
        return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
    }
    
    public Date convertToDate(LocalDate localDate){
        return java.util.Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public void validarCampos() {
        //textFieldUsuarioInicioSesion.addEventFilter(KeyEvent.ANY, handlerLetters);
        //textFieldNombeRegistroResponsable.addEventFilter(KeyEvent.ANY, handlerLetters);
        textFieldNumeroRegistroResponsable.addEventFilter(KeyEvent.ANY, handlerNumbers);
    }
    
    public void ocultarMenuLateral() {
        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), anchorPaneWhiteInicio);
        fadeTransition1.setFromValue(0.15);
        fadeTransition1.setToValue(0);
        fadeTransition1.play();
            
        fadeTransition1.setOnFinished(event1 -> {
            anchorPaneWhiteInicio.setVisible(false);
        });

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), anchorPaneMenuLateral);
        translateTransition1.setByX(-600);
        translateTransition1.play();
    }
    
    public void mostrarMenuLateral() {
        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), anchorPaneWhiteInicio);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(0.15);
        fadeTransition1.play();
            
        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), anchorPaneMenuLateral);
        translateTransition1.setByX(+600);
        translateTransition1.play();
    }
    
    public void mainMenuLateral() {
        ocultarMenuLateral();

        imageViewMenuLateral.setOnMouseClicked(event -> {       
            anchorPaneWhiteInicio.setVisible(true);
            imageViewMenuLateral.setVisible(false);
            mostrarMenuLateral();
        });
        
        imageViewBackMenuLateral.setOnMouseClicked(event -> {
            ocultarMenuLateral();
            imageViewMenuLateral.setVisible(true);
        });
    }
    
    public void mostrarGuiCamposInvalidos() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Campos inválidos en el formulario");        
        alert.setHeaderText("Existen campos invalidos en el formulario");
        alert.setContentText("Revisa los campos del formulario");
        alert.show();
    }
    
    public void mostrarGuiRegistroRepetido() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro repetido");        
        alert.setHeaderText("El registro ya existe en la base de datos");
        alert.setContentText("");
        alert.show();
    }
    
    
    /*-----------------------------------------------------------*/
    
    
    @FXML
    public void mostrarGuiRegistrarNuevoResponsable() {
        anchorPaneRegistroDeResponsable.setVisible(true);
    }
    
    public void quitarBordeCamposRegistroResponsable() {
        String fondoGris = "-fx-background-color: #ededed";
        String fondoBlanco = "-fx-background-color: #FFFFFF";
        String bordeRedondeado = "-fx-border-radius: 20";
        String fondoRedondeado = "-fx-background-radius: 20";
        String colorBorde = "-fx-border-color: #cfcfcf";
        
        textFieldNombeRegistroResponsable.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
        textFieldNumeroRegistroResponsable.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
        comboBoxTurnoRegistroResponsable.setStyle(fondoGris + "; " + bordeRedondeado + "; " + fondoRedondeado);
        passwordFieldContrasenaRegistroResponsable.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
        passwordFieldConfirmacionContrasenaRegistroResponsable.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
    }
    
    public void mostrarCamposInvalidosRegistroResponsable(CamposInvalidosRegistroResponsable camposInvalidosRegistroResponsable) {
        String bordeRojo = "-fx-background-color: #fcbdb8";
        String bordeVerde = "-fx-background-color: #bbfcb8";
        String fondoRedondeado = "-fx-background-radius: 20";
        
        if (!camposInvalidosRegistroResponsable.getNombreValido()) {
            textFieldNombeRegistroResponsable.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            textFieldNombeRegistroResponsable.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroResponsable.getNumeroTelefonicoResponsable()) {
            textFieldNumeroRegistroResponsable.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            textFieldNumeroRegistroResponsable.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroResponsable.getTurnoValido()) {
            comboBoxTurnoRegistroResponsable.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            comboBoxTurnoRegistroResponsable.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroResponsable.getContrasenaValida()) {
            passwordFieldContrasenaRegistroResponsable.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            passwordFieldContrasenaRegistroResponsable.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroResponsable.getConfirmacionContrasenaValida()) {
            passwordFieldConfirmacionContrasenaRegistroResponsable.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            passwordFieldConfirmacionContrasenaRegistroResponsable.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroResponsable.getContrasenasIguales()) {
            passwordFieldContrasenaRegistroResponsable.setStyle(bordeVerde + "; " + fondoRedondeado);
            passwordFieldConfirmacionContrasenaRegistroResponsable.setStyle(bordeRojo + "; " + fondoRedondeado);
            labelContrasenasIguales.setVisible(true);
        } else {
            passwordFieldContrasenaRegistroResponsable.setStyle(bordeVerde + "; " + fondoRedondeado);
            passwordFieldConfirmacionContrasenaRegistroResponsable.setStyle(bordeVerde + "; " + fondoRedondeado);
            labelContrasenasIguales.setVisible(false);
        }
    }
    
    public void llenarComboBoxTurnoRegistroResponsable() {
        ObservableList<String> listaTurnos = FXCollections.observableArrayList();
        listaTurnos.add("Matutino");
        listaTurnos.add("Vespertino");
        comboBoxTurnoRegistroResponsable.setItems(listaTurnos); 
    }
    
    public void mostrarGuiConfirmacionRegistroResponsable() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmación de registro");        
        alert.setHeaderText("El registro se llevo acabo correctamente!");
         alert.setContentText("El Responsable se ha registrado");
        Optional<ButtonType> buttonAceptarRegistro = alert.showAndWait();
        if (buttonAceptarRegistro.get() == ButtonType.OK){
            salirRegistroDeNuevoResponsabe();
        }
    }
    
    @FXML
    public void registrarNuevoResponsable(ActionEvent actionEvent) {        
        String nombreCompletoResponsable = null;
        String turnoResponsable = null;
        String contrasenaResponsable = null;
        String contrasenaEsparada = null;
        long numeroTelefonicoResponsable = 0;
        
        boolean nombreValido = false; 
        boolean turnoValido = false;
        boolean contrasenaValida = false; 
        boolean confirmacionContrasenaValida = false;
        boolean numeroTelefonicoValido = false;
        
        if (!textFieldNombeRegistroResponsable.getText().isEmpty()) {
            nombreCompletoResponsable = textFieldNombeRegistroResponsable.getText();
            nombreValido = true;
        }
        if (comboBoxTurnoRegistroResponsable.getSelectionModel().getSelectedItem() != null) {
            turnoResponsable = comboBoxTurnoRegistroResponsable.getSelectionModel().getSelectedItem();
            turnoValido = true;
        }
        if (!passwordFieldContrasenaRegistroResponsable.getText().isEmpty()) {
            contrasenaResponsable = passwordFieldContrasenaRegistroResponsable.getText().trim();
            contrasenaValida = true;
        }
        if (!passwordFieldConfirmacionContrasenaRegistroResponsable.getText().isEmpty()) {
            contrasenaEsparada = passwordFieldConfirmacionContrasenaRegistroResponsable.getText().trim();
            confirmacionContrasenaValida = true;
        }
        try {
            if (!textFieldNumeroRegistroResponsable.getText().isEmpty()) {
                numeroTelefonicoResponsable = Long.parseLong(textFieldNumeroRegistroResponsable.getText()); 
                numeroTelefonicoValido = true;
            }    
        } catch (NumberFormatException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean contrasenasIguales = false;
        if (contrasenaValida && confirmacionContrasenaValida) {
            if (contrasenaResponsable.equals(contrasenaEsparada) && contrasenaEsparada != null) {
                contrasenasIguales = true;
            }
        }
        String nombreJefeRegistro = labelNombreUsuarioCargado.getText();
        if (contrasenasIguales && nombreValido && turnoValido && numeroTelefonicoValido) {
            boolean responsableRepetido = false; 
            Responsable responsable = new Responsable(nombreCompletoResponsable, numeroTelefonicoResponsable, turnoResponsable, contrasenaResponsable, nombreJefeRegistro);
            String nombreEsperado = null;
            for (int i = 0; i < responsableDAO.consultarListaDeResponsables().size(); i++) {
                nombreEsperado = responsableDAO.consultarListaDeResponsables().get(i).getNombreCompleto();
                if (nombreCompletoResponsable.equals(nombreEsperado)) {
                    nombreEsperado = responsableDAO.consultarListaDeResponsables().get(i).getNombreCompleto();
                    responsableRepetido = true;
                } 
            }
            if (responsableRepetido) {
                mostrarGuiRegistroRepetido();
                nombreValido = false;
            } else {
                jefeCentroComputoDAO.registrarNuevoResponsable(responsable);
                mostrarGuiConfirmacionRegistroResponsable();
            }
            CamposInvalidosRegistroResponsable camposInvalidosRegistroResponsable = new CamposInvalidosRegistroResponsable(nombreValido, turnoValido, contrasenaValida, confirmacionContrasenaValida, numeroTelefonicoValido, contrasenasIguales);
            mostrarCamposInvalidosRegistroResponsable(camposInvalidosRegistroResponsable);
        } else {
            mostrarGuiCamposInvalidos();
            CamposInvalidosRegistroResponsable camposInvalidosRegistroResponsable = new CamposInvalidosRegistroResponsable(nombreValido, turnoValido, contrasenaValida, confirmacionContrasenaValida, numeroTelefonicoValido, contrasenasIguales);
            mostrarCamposInvalidosRegistroResponsable(camposInvalidosRegistroResponsable);
        }
    }
    
    public void salirRegistroDeNuevoResponsabe() {
        textFieldNombeRegistroResponsable.setText("");
        textFieldNumeroRegistroResponsable.setText("");
        passwordFieldContrasenaRegistroResponsable.setText("");
        passwordFieldConfirmacionContrasenaRegistroResponsable.setText("");
        comboBoxTurnoRegistroResponsable.getSelectionModel().clearSelection();
        quitarBordeCamposRegistroResponsable();
        labelContrasenasIguales.setVisible(false);
        anchorPaneRegistroDeResponsable.setVisible(false); 
    }
    
    @FXML
    public void mostrarGuiCancelarRegistroResponsable(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelar registro de Responsable");        
        alert.setHeaderText("¿Desea cancelar el registro?");
        alert.setContentText("El Responsable no se registrará");
        Optional<ButtonType> buttonCancelarRegistro = alert.showAndWait();
        if (buttonCancelarRegistro.get() == ButtonType.OK){
            salirRegistroDeNuevoResponsabe();
            imageViewMenuLateral.setVisible(true);
        }
    }
    
    
    
    /*-------------------------------------------------------------------*/
    @FXML
    public void mostrarGuiRegistrarNuevoDispositivo() {
        anchorPaneRegistroDeDispositivo.setVisible(true);
    }
    
    public void quitarBordeCamposRegistroDispositivo() {
        String fondoGris = "-fx-background-color: #ededed";
        String fondoBlanco = "-fx-background-color: #FFFFFF";
        String bordeRedondeado = "-fx-border-radius: 20";
        String fondoRedondeado = "-fx-background-radius: 20";
        String colorBorde = "-fx-border-color: #cfcfcf";
        
        textFieldClaveRegistroDispositivo.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
        comboBoxCategoriaRegistroDispositivo.setStyle(fondoGris + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
        dataPickerFechaRegistroDispositivo.setStyle(fondoGris + "; " + bordeRedondeado + "; " + fondoRedondeado);
        textFieldDescripcionRegistroDispositivo.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
        comboBoxEstatusRegistroDispositivo.setStyle(fondoGris + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
        textFieldClaveProyectorRegistroDispositivo.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
        textFieldLugarProyectorRegistroDispositivo.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
    }
    
    public void mostrarCamposInvalidosRegistroDispositivo(CamposInvalidosRegistroDispositivo camposInvalidosRegistroDispositivo) {
        String bordeRojo = "-fx-background-color: #fcbdb8";
        String bordeVerde = "-fx-background-color: #bbfcb8";
        String fondoRedondeado = "-fx-background-radius: 20";
        
        if (!camposInvalidosRegistroDispositivo.getCategoriaDispositivoValida()) {
            comboBoxCategoriaRegistroDispositivo.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            comboBoxCategoriaRegistroDispositivo.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroDispositivo.getClaveDispositivoValida()) {
            textFieldClaveRegistroDispositivo.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            textFieldClaveRegistroDispositivo.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroDispositivo.getDescripcionDispositivoValida()) {
            textFieldDescripcionRegistroDispositivo.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            textFieldDescripcionRegistroDispositivo.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroDispositivo.getEstatusDispositivoValido()) {
            comboBoxEstatusRegistroDispositivo.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            comboBoxEstatusRegistroDispositivo.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroDispositivo.getFechaIngresoDispositivoValida()) {
            dataPickerFechaRegistroDispositivo.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            dataPickerFechaRegistroDispositivo.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroDispositivo.getLugarProyectorControlValida()) {
            textFieldLugarProyectorRegistroDispositivo.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            textFieldLugarProyectorRegistroDispositivo.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroDispositivo.getClaveProyectorControlValida()) {
            textFieldClaveProyectorRegistroDispositivo.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            textFieldClaveProyectorRegistroDispositivo.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
    }
    
    public void llenarComboBoxCategoriaRegistroDispositivo() {
        ObservableList<String> listaCategoriasDispositivos = FXCollections.observableArrayList();
        listaCategoriasDispositivos.add("Cable");
        listaCategoriasDispositivos.add("Conector");
        listaCategoriasDispositivos.add("Control");
        listaCategoriasDispositivos.add("Proyector");
        listaCategoriasDispositivos.add("Laptop");
        comboBoxCategoriaRegistroDispositivo.setItems(listaCategoriasDispositivos);
    }
    
    public void llenarComboBoxEstatusRegistroDispositivo() {
        ObservableList<String> listaEstatusDispositivo = FXCollections.observableArrayList();
        listaEstatusDispositivo.add("Disponible");
        comboBoxEstatusRegistroDispositivo.setItems(listaEstatusDispositivo); 
    }
    
    public void mostrarGuiConfirmacionRegistroDispositivo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmación de registro");        
        alert.setHeaderText("El registro se llevo acabo correctamente!");
        alert.setContentText("El Dispositivo se ha registrado");
        Optional<ButtonType> buttonAceptarRegistro = alert.showAndWait();
        if (buttonAceptarRegistro.get() == ButtonType.OK){
            salirRegistroDeDispositivo();
        }
    }
    
    public void camposAdicionalesDeControlDispositivo(ActionEvent actionEvent) {
        String categoriaControl = null;
        if (comboBoxCategoriaRegistroDispositivo.getSelectionModel().getSelectedItem() != null) {
            categoriaControl = comboBoxCategoriaRegistroDispositivo.getSelectionModel().getSelectedItem();        
            if (categoriaControl.equals("Control")) {
                labelLugarProyectorRegistroDispositivo.setVisible(true);
                textFieldLugarProyectorRegistroDispositivo.setVisible(true);
                textFieldLugarProyectorRegistroDispositivo.setText("");
                labelClaveProyectorRegistroDispositivo.setVisible(true);
                textFieldClaveProyectorRegistroDispositivo.setVisible(true);
                textFieldClaveProyectorRegistroDispositivo.setText("");
            } else {
                textFieldLugarProyectorRegistroDispositivo.setText("");
                labelLugarProyectorRegistroDispositivo.setVisible(false);
                textFieldLugarProyectorRegistroDispositivo.setVisible(false);
                textFieldClaveProyectorRegistroDispositivo.setText("");
                labelClaveProyectorRegistroDispositivo.setVisible(false);
                textFieldClaveProyectorRegistroDispositivo.setVisible(false);
            }
        }
    }
    
    @FXML
    public void registrarNuevoDispositivo(ActionEvent actionEvent) {  
        String categoriaDispositivo = null;
        String claveDispositivo = null;
        String descripcionDispositivo = null;
        String estatusDispositivo = null;
        LocalDate fechaIngresoDispositivo = null;
        String lugarProyectorControl = null;
        String claveProyectorControl = null;
        
        boolean categoriaDispositivoValida = false;
        boolean claveDispositivoValida = false; 
        boolean descripcionDispositivoValida = false;
        boolean estatusDispositivoValido = false; 
        boolean fechaIngresoDispositivoValida = false;
        boolean lugarProyectorControlValida = false;
        boolean claveProyectorControlValida = false;
        
        if (comboBoxCategoriaRegistroDispositivo.getSelectionModel().getSelectedItem() != null) {
            categoriaDispositivo = comboBoxCategoriaRegistroDispositivo.getSelectionModel().getSelectedItem();
            categoriaDispositivoValida = true;
        }        
        if (!textFieldClaveRegistroDispositivo.getText().isEmpty()) {
            claveDispositivo = textFieldClaveRegistroDispositivo.getText();
            claveDispositivoValida = true;
        }
        if (!textFieldDescripcionRegistroDispositivo.getText().isEmpty()) {
            descripcionDispositivo = textFieldDescripcionRegistroDispositivo.getText();
            descripcionDispositivoValida = true;
        }
        if (dataPickerFechaRegistroDispositivo.getValue() != null) {
            fechaIngresoDispositivo = dataPickerFechaRegistroDispositivo.getValue();
            fechaIngresoDispositivoValida = true;
        }
        if (comboBoxEstatusRegistroDispositivo.getSelectionModel().getSelectedItem() != null) {
            estatusDispositivo = comboBoxEstatusRegistroDispositivo.getSelectionModel().getSelectedItem();
            estatusDispositivoValido = true;
        }
        
        if (categoriaDispositivoValida && categoriaDispositivo.equals("Control")) {
            if (!textFieldLugarProyectorRegistroDispositivo.getText().isEmpty()) {
                lugarProyectorControl = textFieldLugarProyectorRegistroDispositivo.getText();
                lugarProyectorControlValida = true;
            }
            if (!textFieldClaveProyectorRegistroDispositivo.getText().isEmpty()) {
                claveProyectorControl = textFieldClaveProyectorRegistroDispositivo.getText();
                claveProyectorControlValida = true;
            }
        }
        int resultadoExitoso = 0;
        String nombreRegistro = labelNombreUsuarioCargado.getText();
        boolean existeRegistro = false; 
        for (int i = 0; i < dispositivoDAO.consultarTodosDispositivos().size(); i++) {
            String claveDispositivoEsperada = dispositivoDAO.consultarTodosDispositivos().get(i).getClave();
            if (claveDispositivo.equals(claveDispositivoEsperada)) {
                existeRegistro = true; 
            }
        }
        if (claveDispositivoValida && descripcionDispositivoValida && estatusDispositivoValido && fechaIngresoDispositivoValida && !existeRegistro) {      
            if (categoriaDispositivo.equals("Cable")) {
                boolean cableRepetido = false; 
                Cable cable = new Cable(claveDispositivo, descripcionDispositivo, estatusDispositivo, convertToDate(fechaIngresoDispositivo), nombreRegistro);
                String claveControlEsperada = null;
                CamposInvalidosRegistroDispositivo camposInvalidosRegistroDispositivo = new CamposInvalidosRegistroDispositivo(categoriaDispositivoValida, claveDispositivoValida, descripcionDispositivoValida, estatusDispositivoValido, fechaIngresoDispositivoValida, lugarProyectorControlValida, claveProyectorControlValida);
                mostrarCamposInvalidosRegistroDispositivo(camposInvalidosRegistroDispositivo);
                for (int i = 0; i < dispositivoDAO.consultarListaCables().size(); i++) {
                    claveControlEsperada = dispositivoDAO.consultarListaCables().get(i).getClave();
                    if (claveDispositivo.equals(claveControlEsperada)) {
                        claveControlEsperada = dispositivoDAO.consultarListaCables().get(i).getClave();
                        cableRepetido = true;
                    }
                } 
                if (cableRepetido) {
                    mostrarGuiRegistroRepetido();
                    camposInvalidosRegistroDispositivo.setClaveDispositivoValida(false);
                    mostrarCamposInvalidosRegistroDispositivo(camposInvalidosRegistroDispositivo);
                } else {
                    dispositivoDAO.registrarNuevoCable(cable);
                    mostrarGuiConfirmacionRegistroDispositivo();
                }
            }  
            if (categoriaDispositivo.equals("Conector")) {
                boolean conectorRepetido = false; 
                Conector conector = new Conector(claveDispositivo, descripcionDispositivo, estatusDispositivo, convertToDate(fechaIngresoDispositivo), nombreRegistro);
                String claveConectorEsperada = null;
                CamposInvalidosRegistroDispositivo camposInvalidosRegistroDispositivo = new CamposInvalidosRegistroDispositivo(categoriaDispositivoValida, claveDispositivoValida, descripcionDispositivoValida, estatusDispositivoValido, fechaIngresoDispositivoValida, lugarProyectorControlValida, claveProyectorControlValida);
                mostrarCamposInvalidosRegistroDispositivo(camposInvalidosRegistroDispositivo);
                for (int i = 0; i < dispositivoDAO.consultarListaConectores().size(); i++) {
                    claveConectorEsperada = dispositivoDAO.consultarListaConectores().get(i).getClave();
                    if (claveDispositivo.equals(claveConectorEsperada)) {
                        claveConectorEsperada = dispositivoDAO.consultarListaCables().get(i).getClave();
                        conectorRepetido = true;
                    }
                } 
                if (conectorRepetido) {
                    mostrarGuiRegistroRepetido();
                    camposInvalidosRegistroDispositivo.setClaveDispositivoValida(false);
                    mostrarCamposInvalidosRegistroDispositivo(camposInvalidosRegistroDispositivo);
                } else {
                    dispositivoDAO.registrarNuevoConector(conector);
                    mostrarGuiConfirmacionRegistroDispositivo();
                }
            }
            if (categoriaDispositivo.equals("Control")) {
                boolean controlRepetido = false; 
                Control control = new Control(claveDispositivo, descripcionDispositivo, estatusDispositivo, convertToDate(fechaIngresoDispositivo), lugarProyectorControl, claveProyectorControl, nombreRegistro);
                String claveControlEsperada = null;
                CamposInvalidosRegistroDispositivo camposInvalidosRegistroDispositivo = new CamposInvalidosRegistroDispositivo(categoriaDispositivoValida, claveDispositivoValida, descripcionDispositivoValida, estatusDispositivoValido, fechaIngresoDispositivoValida, lugarProyectorControlValida, claveProyectorControlValida);
                mostrarCamposInvalidosRegistroDispositivo(camposInvalidosRegistroDispositivo);
                for (int i = 0; i < dispositivoDAO.consultarListaControles().size(); i++) {
                    claveControlEsperada = dispositivoDAO.consultarListaControles().get(i).getClave();
                    if (claveDispositivo.equals(claveControlEsperada)) {
                        claveControlEsperada = dispositivoDAO.consultarListaLaptops().get(i).getClave();
                        controlRepetido = true;
                    }
                } 
                if (controlRepetido) {
                    mostrarGuiRegistroRepetido();
                    camposInvalidosRegistroDispositivo.setClaveDispositivoValida(false);
                    mostrarCamposInvalidosRegistroDispositivo(camposInvalidosRegistroDispositivo); 
                } else {
                    dispositivoDAO.registrarNuevoControl(control);
                    mostrarGuiConfirmacionRegistroDispositivo();
                }
            }
            if (categoriaDispositivo.equals("Laptop")) {
                boolean laptopRepetida = false; 
                Laptop laptop = new Laptop(claveDispositivo, descripcionDispositivo, estatusDispositivo, convertToDate(fechaIngresoDispositivo), nombreRegistro);
                String claveLaptopEsperada = null;
                CamposInvalidosRegistroDispositivo camposInvalidosRegistroDispositivo = new CamposInvalidosRegistroDispositivo(categoriaDispositivoValida, claveDispositivoValida, descripcionDispositivoValida, estatusDispositivoValido, fechaIngresoDispositivoValida, lugarProyectorControlValida, claveProyectorControlValida);
                mostrarCamposInvalidosRegistroDispositivo(camposInvalidosRegistroDispositivo);
                for (int i = 0; i < dispositivoDAO.consultarListaLaptops().size(); i++) {
                    claveLaptopEsperada = dispositivoDAO.consultarListaLaptops().get(i).getClave();
                    if (claveDispositivo.equals(claveLaptopEsperada)) {
                        claveLaptopEsperada = dispositivoDAO.consultarListaLaptops().get(i).getClave();
                        laptopRepetida = true;
                    }
                } 
                if (laptopRepetida) {
                    mostrarGuiRegistroRepetido();
                    camposInvalidosRegistroDispositivo.setClaveDispositivoValida(false);
                    mostrarCamposInvalidosRegistroDispositivo(camposInvalidosRegistroDispositivo);
                } else {
                    dispositivoDAO.registrarNuevaLapatop(laptop);
                    mostrarGuiConfirmacionRegistroDispositivo();
                }                
            }
            if (categoriaDispositivo.equals("Proyector")) {
                boolean proyectorRepetido = false; 
                Proyector proyector = new Proyector(claveDispositivo, descripcionDispositivo, estatusDispositivo, convertToDate(fechaIngresoDispositivo), nombreRegistro);
                String claveProyectorEsperada = null;
                CamposInvalidosRegistroDispositivo camposInvalidosRegistroDispositivo = new CamposInvalidosRegistroDispositivo(categoriaDispositivoValida, claveDispositivoValida, descripcionDispositivoValida, estatusDispositivoValido, fechaIngresoDispositivoValida, lugarProyectorControlValida, claveProyectorControlValida);
                mostrarCamposInvalidosRegistroDispositivo(camposInvalidosRegistroDispositivo);
                for (int i = 0; i < dispositivoDAO.consultarListaProyectores().size(); i++) {
                    claveProyectorEsperada = dispositivoDAO.consultarListaProyectores().get(i).getClave();
                    if (claveDispositivo.equals(claveProyectorEsperada)) {
                        claveProyectorEsperada = dispositivoDAO.consultarListaProyectores().get(i).getClave();
                        proyectorRepetido = true;
                    }
                } 
                if (proyectorRepetido) {
                    mostrarGuiRegistroRepetido();
                    camposInvalidosRegistroDispositivo.setClaveDispositivoValida(false);
                    mostrarCamposInvalidosRegistroDispositivo(camposInvalidosRegistroDispositivo);
                } else {
                    dispositivoDAO.registrarNuevoProyector(proyector);
                    mostrarGuiConfirmacionRegistroDispositivo();
                }                
            }
        } else {
            mostrarGuiCamposInvalidos();
            CamposInvalidosRegistroDispositivo camposInvalidosRegistroDispositivo = new CamposInvalidosRegistroDispositivo(categoriaDispositivoValida, claveDispositivoValida, descripcionDispositivoValida, estatusDispositivoValido, fechaIngresoDispositivoValida, lugarProyectorControlValida, claveProyectorControlValida);
            mostrarCamposInvalidosRegistroDispositivo(camposInvalidosRegistroDispositivo);
        }
        
    }
    
    public void salirRegistroDeDispositivo() {
        textFieldDescripcionRegistroDispositivo.setText("");
        textFieldClaveRegistroDispositivo.setText("");
        comboBoxCategoriaRegistroDispositivo.getSelectionModel().clearSelection();
        comboBoxEstatusRegistroDispositivo.getSelectionModel().clearSelection();
        LocalDate localDate = null;
        dataPickerFechaRegistroDispositivo.setValue(localDate);
        labelLugarProyectorRegistroDispositivo.setVisible(false);
        textFieldLugarProyectorRegistroDispositivo.setVisible(false);
        labelClaveProyectorRegistroDispositivo.setVisible(false);
        textFieldClaveProyectorRegistroDispositivo.setVisible(false);
        quitarBordeCamposRegistroDispositivo();
        anchorPaneRegistroDeDispositivo.setVisible(false);  
    }
    
    @FXML
    public void mostrarGuiCancelarRegistroDispositivo(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelar registro de Dispositivo");        
        alert.setHeaderText("¿Desea cancelar el registro?");
        alert.setContentText("El Dispositivo no se registrará");
        Optional<ButtonType> buttonCancelarRegistro = alert.showAndWait();
        if (buttonCancelarRegistro.get() == ButtonType.OK){
            salirRegistroDeDispositivo();
            imageViewMenuLateral.setVisible(true);
        }
    }
    
    
    
    /*----------------------------------------------------*/
    @FXML
    public void mostrarGuiBuscarDispositivo() {
        anchorPaneBuscarDispositivo.setVisible(true);
        llenarComboBoxFiltroBusqueda();
    }
    
    public void llenarComboBoxFiltroBusqueda() {
        ObservableList<String> listaFiltosBusqueda = FXCollections.observableArrayList();
        listaFiltosBusqueda.add("Cables");
        listaFiltosBusqueda.add("Conectores");
        listaFiltosBusqueda.add("Controles");
        listaFiltosBusqueda.add("Laptops");
        listaFiltosBusqueda.add("Proyectores");
        listaFiltosBusqueda.add("Todos los dispositivos");
        comboBoxFiltroBusqueda.setItems(listaFiltosBusqueda); 
    }
    
    public void mostrarTablasDispositivos(ActionEvent actionEvent) {
        String tipoDispositivo = null;
        boolean noSeleccionadaCategoria = comboBoxFiltroBusqueda.getSelectionModel().isEmpty();
        if (!noSeleccionadaCategoria) {
            tipoDispositivo = comboBoxFiltroBusqueda.getSelectionModel().getSelectedItem(); 
            String estutus = "Disponible"; 
            switch (tipoDispositivo) {
                case "Cables": 
                    limpiarSeleccionBusquedaTablas();
                    tableViewBusquedaConector.setVisible(false);
                    tableViewBusquedaControl.setVisible(false);
                    tableViewBusquedaLaptop.setVisible(false);
                    tableViewBusquedaProyector.setVisible(false);
                    tableViewBusquedaDispositivo.setVisible(false);
                    ObservableList<Cable> listaCables = FXCollections.observableArrayList();
                    for (int i = 0; i < dispositivoDAO.consultarListaCables().size(); i++) {
                        String estatusEsperado = dispositivoDAO.consultarListaCables().get(i).getEstatus();
                        if (estatusEsperado.equals(estutus)) {
                            listaCables.add(dispositivoDAO.consultarListaCables().get(i));
                        }
                    }    
                    tableColumnBusquedaClaveCable.setCellValueFactory(new PropertyValueFactory("clave"));
                    tableColumnBusquedaDescripcionCable.setCellValueFactory(new PropertyValueFactory("descripcion"));
                    tableColumnBusquedaFechaCable.setCellValueFactory(new PropertyValueFactory("fechaIngreso"));
                    tableColumnBusquedaEstatusCable.setCellValueFactory(new PropertyValueFactory("estatus"));
                    tableViewBusquedaCable.setItems(listaCables);
                    tableViewBusquedaCable.setVisible(true);
                break;

                case "Conectores":
                    limpiarSeleccionBusquedaTablas();
                    tableViewBusquedaCable.setVisible(false);
                    tableViewBusquedaControl.setVisible(false);
                    tableViewBusquedaLaptop.setVisible(false);
                    tableViewBusquedaProyector.setVisible(false);
                    tableViewBusquedaDispositivo.setVisible(false);
                    ObservableList<Conector> listaConectores = FXCollections.observableArrayList();
                    for (int i = 0; i < dispositivoDAO.consultarListaConectores().size(); i++) { 
                        String estatusEsperado = dispositivoDAO.consultarListaConectores().get(i).getEstatus();
                        if (estatusEsperado.equals(estutus)) {
                            listaConectores.add(dispositivoDAO.consultarListaConectores().get(i));
                        }
                    }    
                    tableColumnBusquedaClaveConector.setCellValueFactory(new PropertyValueFactory("clave"));
                    tableColumnBusquedaDescripcionConector.setCellValueFactory(new PropertyValueFactory("descripcion"));
                    tableColumnBusquedaFechaConector.setCellValueFactory(new PropertyValueFactory("fechaIngreso"));
                    tableColumnBusquedaEstatusConector.setCellValueFactory(new PropertyValueFactory("estatus"));
                    tableViewBusquedaConector.setItems(listaConectores);
                    tableViewBusquedaConector.setVisible(true);
                break;

                case "Controles":
                    limpiarSeleccionBusquedaTablas();
                    tableViewBusquedaCable.setVisible(false);
                    tableViewBusquedaConector.setVisible(false);
                    tableViewBusquedaLaptop.setVisible(false);
                    tableViewBusquedaProyector.setVisible(false);
                    tableViewBusquedaDispositivo.setVisible(false);
                    ObservableList<Control> listaControles = FXCollections.observableArrayList();
                    for (int i = 0; i < dispositivoDAO.consultarListaControles().size(); i++) {
                        String estatusEsperado = dispositivoDAO.consultarListaControles().get(i).getEstatus();
                        if (estatusEsperado.equals(estutus)) {
                            listaControles.add(dispositivoDAO.consultarListaControles().get(i));
                        }
                    }    
                    tableColumnBusquedaClaveControl.setCellValueFactory(new PropertyValueFactory("clave"));
                    tableColumnBusquedaDescripcionControl.setCellValueFactory(new PropertyValueFactory("descripcion"));
                    tableColumnBusquedaFechaControl.setCellValueFactory(new PropertyValueFactory("fechaIngreso"));
                    tableColumnBusquedaEstatusControl.setCellValueFactory(new PropertyValueFactory("estatus"));
                    tableColumBusquedaLugarProyectorControl.setCellValueFactory(new PropertyValueFactory("lugarProyector"));
                    tableColumBusquedaClaveProyectorControl.setCellValueFactory(new PropertyValueFactory("claveProyector"));
                    tableViewBusquedaControl.setItems(listaControles);
                    tableViewBusquedaControl.setVisible(true);
                break;

                case "Laptops":
                    limpiarSeleccionBusquedaTablas();
                    tableViewBusquedaCable.setVisible(false);
                    tableViewBusquedaControl.setVisible(false);
                    tableViewBusquedaConector.setVisible(false);
                    tableViewBusquedaProyector.setVisible(false);
                    tableViewBusquedaDispositivo.setVisible(false);
                    ObservableList<Laptop> listaLaptops = FXCollections.observableArrayList();
                    for (int i = 0; i < dispositivoDAO.consultarListaLaptops().size(); i++) {
                        String estatusEsperado = dispositivoDAO.consultarListaLaptops().get(i).getEstatus();
                        if (estatusEsperado.equals(estutus)) {
                            listaLaptops.add(dispositivoDAO.consultarListaLaptops().get(i));
                        }                  
                    }    
                    tableColumnBusquedaClaveLaptop.setCellValueFactory(new PropertyValueFactory("clave"));
                    tableColumnBusquedaDescripcionLaptop.setCellValueFactory(new PropertyValueFactory("descripcion"));
                    tableColumnBusquedaFechaLaptop.setCellValueFactory(new PropertyValueFactory("fechaIngreso"));
                    tableColumnBusquedaEstatusLaptop.setCellValueFactory(new PropertyValueFactory("estatus"));
                    tableViewBusquedaLaptop.setItems(listaLaptops);
                    tableViewBusquedaLaptop.setVisible(true);
                break;

                case "Proyectores":
                    limpiarSeleccionBusquedaTablas();
                    tableViewBusquedaCable.setVisible(false);
                    tableViewBusquedaControl.setVisible(false);
                    tableViewBusquedaConector.setVisible(false);
                    tableViewBusquedaLaptop.setVisible(false);
                    tableViewBusquedaDispositivo.setVisible(false);
                    ObservableList<Proyector> listaProyectores = FXCollections.observableArrayList();
                    for (int i = 0; i < dispositivoDAO.consultarListaProyectores().size(); i++) {
                        String estatusEsperado = dispositivoDAO.consultarListaProyectores().get(i).getEstatus();
                        if (estatusEsperado.equals(estutus)) {
                            listaProyectores.add(dispositivoDAO.consultarListaProyectores().get(i));
                        }                                      
                    }    
                    tableColumnBusquedaClaveProyector.setCellValueFactory(new PropertyValueFactory("clave"));
                    tableColumnBusquedaDescripcionProyector.setCellValueFactory(new PropertyValueFactory("descripcion"));
                    tableColumnBusquedaFechaProyector.setCellValueFactory(new PropertyValueFactory("fechaIngreso"));
                    tableColumnBusquedaEstatusProyector.setCellValueFactory(new PropertyValueFactory("estatus"));
                    tableViewBusquedaProyector.setItems(listaProyectores);
                    tableViewBusquedaProyector.setVisible(true);
                break;    

                case "Todos los dispositivos":
                    limpiarSeleccionBusquedaTablas();
                    tableViewBusquedaCable.setVisible(false);
                    tableViewBusquedaConector.setVisible(false);
                    tableViewBusquedaControl.setVisible(false);
                    tableViewBusquedaLaptop.setVisible(false);
                    tableViewBusquedaProyector.setVisible(false);
                    ObservableList<Dispositivo> listaDispositivos = FXCollections.observableArrayList();
                    for (int i = 0; i < dispositivoDAO.consultarTodosDispositivos().size(); i++) {
                        listaDispositivos.add(dispositivoDAO.consultarTodosDispositivos().get(i));
                    }
                    tableColumnBusquedaClaveDispositivo.setCellValueFactory(new PropertyValueFactory("clave"));
                    tableColumnBusquedaDescripcionDispositivo.setCellValueFactory(new PropertyValueFactory("descripcion"));
                    tableColumnBusquedaFechaDispositivo.setCellValueFactory(new PropertyValueFactory("fechaIngreso"));
                    tableColumnBusquedaEstatusDispositivo.setCellValueFactory(new PropertyValueFactory("estatus"));
                    tableViewBusquedaDispositivo.setItems(listaDispositivos);
                    tableViewBusquedaDispositivo.setVisible(true);
                break; 

                default:
                    break;
            }
        }
        mostrarCaracteristicasDispositivos();
    }
    
    public void mostrarCaracteristicasDispositivos() {
        tableViewBusquedaCable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cable>() {
            @Override
            public void changed(ObservableValue<? extends Cable> observable, Cable oldCable, Cable newCable) {
                boolean noSeleccionadoDispositivo = tableViewBusquedaCable.getSelectionModel().isEmpty();
                if (!noSeleccionadoDispositivo) {
                    anchorPaneCaractetisticasDispositivo.setVisible(true);
                    String claveCable = tableViewBusquedaCable.getSelectionModel().getSelectedItem().getClave();
                    ObservableList<Cable> caracteristicCable = FXCollections.observableArrayList();
                    for (int i = 0; i < dispositivoDAO.consultarListaCables().size(); i++) {
                        String claveCableEsperada = dispositivoDAO.consultarListaCables().get(i).getClave();
                        if (claveCable.equals(claveCableEsperada)) {
                            caracteristicCable.add(dispositivoDAO.consultarListaCables().get(i));
                        }
                    }
                    tableColumnCaracteristicasClaveCable.setCellValueFactory(new PropertyValueFactory("clave"));
                    tableColumnCaracteristicasDescripcionCable.setCellValueFactory(new PropertyValueFactory("descripcion"));
                    tableColumnCaracteristicasFechaCable.setCellValueFactory(new PropertyValueFactory("fechaIngreso"));
                    tableColumnCaracteristicasEstatusCable.setCellValueFactory(new PropertyValueFactory("estatus"));
                    tableViewCaracteristicasCable.setItems(caracteristicCable);
                    tableViewCaracteristicasCable.setVisible(true);
                    textFieldPrestamoClaveDispositivo.setText(claveCable);
                }
            }          
        });
        
        tableViewBusquedaConector.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Conector>() {
            @Override
            public void changed(ObservableValue<? extends Conector> ov, Conector t, Conector t1) {
                boolean noSeleccionadoDispositivo = tableViewBusquedaConector.getSelectionModel().isEmpty();
                if (!noSeleccionadoDispositivo) {
                    anchorPaneCaractetisticasDispositivo.setVisible(true);
                    String claveConector = tableViewBusquedaConector.getSelectionModel().getSelectedItem().getClave();
                    ObservableList<Conector> caracteristicasConector = FXCollections.observableArrayList();
                    for (int i = 0; i < dispositivoDAO.consultarListaConectores().size(); i++) {
                        String claveConectorEsperada = dispositivoDAO.consultarListaConectores().get(i).getClave();
                        if (claveConector.equals(claveConectorEsperada)) {
                            caracteristicasConector.add(dispositivoDAO.consultarListaConectores().get(i));
                        }
                    }
                    tableColumnCaracteristicasClaveConector.setCellValueFactory(new PropertyValueFactory("clave"));
                    tableColumnCaracteristicasDescripcionConector.setCellValueFactory(new PropertyValueFactory("descripcion"));
                    tableColumnCaracteristicasFechaConector.setCellValueFactory(new PropertyValueFactory("fechaIngreso"));
                    tableColumnCaracteristicasEstatusConector.setCellValueFactory(new PropertyValueFactory("estatus"));
                    tableViewCaracteristicasConector.setItems(caracteristicasConector);
                    tableViewCaracteristicasConector.setVisible(true);
                    textFieldPrestamoClaveDispositivo.setText(claveConector);
                }
            }    
        });
               
        tableViewBusquedaLaptop.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Laptop>() {
            @Override
            public void changed(ObservableValue<? extends Laptop> ov, Laptop t, Laptop t1) {
                boolean noSeleccionadoDispositivo = tableViewBusquedaLaptop.getSelectionModel().isEmpty();
                if (!noSeleccionadoDispositivo) {
                    anchorPaneCaractetisticasDispositivo.setVisible(true);
                    String claveLaptop = tableViewBusquedaLaptop.getSelectionModel().getSelectedItem().getClave();
                    ObservableList<Laptop> caracteristicasLaptop = FXCollections.observableArrayList();
                    for (int i = 0; i < dispositivoDAO.consultarListaLaptops().size(); i++) {
                        String claveLaptopEsperada = dispositivoDAO.consultarListaLaptops().get(i).getClave();
                        if (claveLaptop.equals(claveLaptopEsperada)) {
                            caracteristicasLaptop.add(dispositivoDAO.consultarListaLaptops().get(i));
                        }
                    }
                    tableColumnCaracteristicasClaveLaptop.setCellValueFactory(new PropertyValueFactory("clave"));
                    tableColumnCaracteristicasDescripcionLaptop.setCellValueFactory(new PropertyValueFactory("descripcion"));
                    tableColumnCaracteristicasFechaLaptop.setCellValueFactory(new PropertyValueFactory("fechaIngreso"));
                    tableColumnCaracteristicasEstatusLaptop.setCellValueFactory(new PropertyValueFactory("estatus"));
                    tableViewCaracteristicasLaptop.setItems(caracteristicasLaptop);
                    tableViewCaracteristicasLaptop.setVisible(true);
                    textFieldPrestamoClaveDispositivo.setText(claveLaptop);
                }
            }           
        });
        
        tableViewBusquedaProyector.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Proyector>() {
            @Override
            public void changed(ObservableValue<? extends Proyector> observable, Proyector oldProyector, Proyector newProyector) {
                boolean noSeleccionadoDispositivo = tableViewBusquedaProyector.getSelectionModel().isEmpty();
                if (!noSeleccionadoDispositivo) {
                    anchorPaneCaractetisticasDispositivo.setVisible(true);
                    String claveProyector = tableViewBusquedaProyector.getSelectionModel().getSelectedItem().getClave();
                    ObservableList<Proyector> caracteristicasProyector = FXCollections.observableArrayList();
                    for (int i = 0; i < dispositivoDAO.consultarListaProyectores().size(); i++) {
                        String claveProyectorEsperada = dispositivoDAO.consultarListaProyectores().get(i).getClave();
                        if (claveProyector.equals(claveProyectorEsperada)) {
                            caracteristicasProyector.add(dispositivoDAO.consultarListaProyectores().get(i));
                        }
                    }
                    tableColumnCaracteristicasClaveProyector.setCellValueFactory(new PropertyValueFactory("clave"));
                    tableColumnCaracteristicasDescripcionProyector.setCellValueFactory(new PropertyValueFactory("descripcion"));
                    tableColumnCaracteristicasFechaProyector.setCellValueFactory(new PropertyValueFactory("fechaIngreso"));
                    tableColumnCaracteristicasEstatusProyector.setCellValueFactory(new PropertyValueFactory("estatus"));
                    tableViewCaracteristicasProyector.setItems(caracteristicasProyector);
                    tableViewCaracteristicasProyector.setVisible(true);
                    textFieldPrestamoClaveDispositivo.setText(claveProyector);
                }
            }
        });
        
        tableViewBusquedaControl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Control>() {
            @Override
            public void changed(ObservableValue<? extends Control> observable, Control oldControl, Control newControl) {
                boolean noSeleccionadoDispositivo = tableViewBusquedaControl.getSelectionModel().isEmpty();
                if (!noSeleccionadoDispositivo) {
                    anchorPaneCaractetisticasDispositivo.setVisible(true);
                    String claveControl = tableViewBusquedaControl.getSelectionModel().getSelectedItem().getClave();
                    ObservableList<Control> caracteristicasControl = FXCollections.observableArrayList();
                    for (int i = 0; i < dispositivoDAO.consultarListaControles().size(); i++) {
                        String claveControlEsperada = dispositivoDAO.consultarListaControles().get(i).getClave();
                        if (claveControl.equals(claveControlEsperada)) {
                            caracteristicasControl.add(dispositivoDAO.consultarListaControles().get(i));
                        }
                    }
                    tableColumnCaracteristicasClaveControl.setCellValueFactory(new PropertyValueFactory("clave"));
                    tableColumnCaracteristicasDescripcionControl.setCellValueFactory(new PropertyValueFactory("descripcion"));
                    tableColumnCaracteristicasFechaControl.setCellValueFactory(new PropertyValueFactory("fechaIngreso"));
                    tableColumnCaracteristicasEstatusControl.setCellValueFactory(new PropertyValueFactory("estatus"));
                    tableColumnCaracteristicasLugarControl.setCellValueFactory(new PropertyValueFactory("lugarProyector"));
                    tableColumnCaracteristicasClaveProyectorControl.setCellValueFactory(new PropertyValueFactory("claveProyector"));
                    tableViewCaracteristicasControl.setItems(caracteristicasControl);
                    tableViewCaracteristicasConector.setVisible(true);
                    textFieldPrestamoClaveDispositivo.setText(claveControl);
                }
            }
        });
    }
    
    public void limpiarSeleccionBusquedaTablas() {
        tableViewBusquedaCable.getSelectionModel().clearSelection();
        tableViewBusquedaConector.getSelectionModel().clearSelection();
        tableViewBusquedaControl.getSelectionModel().clearSelection();
        tableViewBusquedaLaptop.getSelectionModel().clearSelection();
        tableViewBusquedaProyector.getSelectionModel().clearSelection();
        tableViewBusquedaDispositivo.getSelectionModel().clearSelection();
    }
    
    public void salirCaracteristicasDispositivo(ActionEvent actionEvent) {
        limpiarSeleccionBusquedaTablas();
        anchorPaneCaractetisticasDispositivo.setVisible(false);
    }
    
    public void llenarComboBoxTipoPrestatario() {
        ObservableList<String> listaTiposPrestatario = FXCollections.observableArrayList();
        listaTiposPrestatario.add("Profesor");
        listaTiposPrestatario.add("Estudiante");
        comboBoxPrestamoTipoPrestatario.setItems(listaTiposPrestatario); 
    }
    
    
    /*-------------------------------------------------------------*/
    
    
    public void mostrarGuiConfirmacionRegistroPrestamos() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmación de registro");        
        alert.setHeaderText("El registro se llevo acabo correctamente!");
        alert.setContentText("El préstamo se ha asignado");
        Optional<ButtonType> buttonAceptarRegistro = alert.showAndWait();
        if (buttonAceptarRegistro.get() == ButtonType.OK){
            salirAsignacionPrestamo();
            imageViewMenuLateral.setVisible(true);
        }
    }
    
    @FXML
    public void asignarPrestamoDispositivo() {
        Date date = new Date();
        convertToLocalDate(date);
        datePickerPrestamoFecha.setValue(convertToLocalDate(date));
        llenarComboBoxTipoPrestatario();
        anchorPanePrestamoDispositivo.setVisible(true);
    }
    
    public void quitarBordeCamposRegistroPrestamo() {
        String fondoGris = "-fx-background-color: #ededed";
        String fondoBlanco = "-fx-background-color: #FFFFFF";
        String bordeRedondeado = "-fx-border-radius: 20";
        String fondoRedondeado = "-fx-background-radius: 20";
        String colorBorde = "-fx-border-color: #cfcfcf";
        
        textFieldPrestamoLugarDispositivo.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
        comboBoxPrestamoTipoPrestatario.setStyle(fondoGris + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
        textFieldPrestamoClavePrestatario.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
        textFieldPrestamoNombrePrestatario.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
    }
    
    public void mostrarCamposInvalidosRegistroPrestamo(CamposInvalidosRegistroPrestamo camposInvalidosRegistroPrestamo) {
        String bordeRojo = "-fx-background-color: #fcbdb8";
        String bordeVerde = "-fx-background-color: #bbfcb8";
        String fondoRedondeado = "-fx-background-radius: 20";
        
        if (!camposInvalidosRegistroPrestamo.getLugarPrestamoValido()) {
            textFieldPrestamoLugarDispositivo.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            textFieldPrestamoLugarDispositivo.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroPrestamo.getNombrePrestatarioValido()) {
            textFieldPrestamoNombrePrestatario.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            textFieldPrestamoNombrePrestatario.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroPrestamo.getNumeroPersonalPrestatarioValido()) {
            textFieldPrestamoClavePrestatario.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            textFieldPrestamoClavePrestatario.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
        
        if (!camposInvalidosRegistroPrestamo.getTipoPrestatarioValido()) {
            comboBoxPrestamoTipoPrestatario.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            comboBoxPrestamoTipoPrestatario.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
    }
    
    public void cambiarEstatusDispositivoPrestado(String claveDispositivo) {
        for (int i = 0; i < dispositivoDAO.consultarListaCables().size(); i++) {
            String claveDispositivoEsperada = dispositivoDAO.consultarListaCables().get(i).getClave();
            if (claveDispositivo.equals(claveDispositivoEsperada)) {
                String descripcionDispostivo = dispositivoDAO.consultarListaCables().get(i).getDescripcion();
                Date fechaIngresoDispostivo = new Date();
                fechaIngresoDispostivo = dispositivoDAO.consultarListaCables().get(i).getFechaIngreso();
                String nombreRegistroDispositivo = dispositivoDAO.consultarListaCables().get(i).getNombreRegistro();
                String estatusDispositivo = dispositivoDAO.consultarListaCables().get(i).getEstatus();
                Cable cable = new Cable(claveDispositivo, descripcionDispostivo, estatusDispositivo, fechaIngresoDispostivo, nombreRegistroDispositivo);
                dispositivoDAO.cambiarEstatusPrestadoCable(cable);  
            }
        }

        for (int i = 0; i < dispositivoDAO.consultarListaConectores().size(); i++) {
            String claveDispositivoEsperada = dispositivoDAO.consultarListaConectores().get(i).getClave();
            if (claveDispositivo.equals(claveDispositivoEsperada)) {
                String descripcionDispostivo = dispositivoDAO.consultarListaConectores().get(i).getDescripcion();
                Date fechaIngresoDispostivo = new Date();
                fechaIngresoDispostivo = dispositivoDAO.consultarListaConectores().get(i).getFechaIngreso();
                String nombreRegistroDispositivo = dispositivoDAO.consultarListaConectores().get(i).getNombreRegistro();
                String estatusDispositivo = dispositivoDAO.consultarListaConectores().get(i).getEstatus();
                Conector conector = new Conector(claveDispositivo, descripcionDispostivo, estatusDispositivo, fechaIngresoDispostivo, nombreRegistroDispositivo);
                dispositivoDAO.cambiarEstatusPrestadoConector(conector);  
            }
        }
        
        for (int i = 0; i < dispositivoDAO.consultarListaControles().size(); i++) {
            String claveDispositivoEsperada = dispositivoDAO.consultarListaControles().get(i).getClave();
            if (claveDispositivo.equals(claveDispositivoEsperada)) {
                String descripcionDispostivo = dispositivoDAO.consultarListaControles().get(i).getDescripcion();
                Date fechaIngresoDispostivo = new Date();
                fechaIngresoDispostivo = dispositivoDAO.consultarListaControles().get(i).getFechaIngreso();
                String nombreRegistroDispositivo = dispositivoDAO.consultarListaControles().get(i).getNombreRegistro();
                String estatusDispositivo = dispositivoDAO.consultarListaControles().get(i).getEstatus();
                String lugarProyector = dispositivoDAO.consultarListaControles().get(i).getLugarProyector();
                String claveProyector = dispositivoDAO.consultarListaControles().get(i).getClaveProyector();
                Control control = new Control(claveDispositivo, descripcionDispostivo, estatusDispositivo, fechaIngresoDispostivo, nombreRegistroDispositivo, lugarProyector, claveProyector);
                dispositivoDAO.cambiarEstatusPrestadoControl(control);  
            }
        }
        
        for (int i = 0; i < dispositivoDAO.consultarListaLaptops().size(); i++) {
            String claveDispositivoEsperada = dispositivoDAO.consultarListaLaptops().get(i).getClave();
            if (claveDispositivo.equals(claveDispositivoEsperada)) {
                String descripcionDispostivo = dispositivoDAO.consultarListaLaptops().get(i).getDescripcion();
                Date fechaIngresoDispostivo = new Date();
                fechaIngresoDispostivo = dispositivoDAO.consultarListaLaptops().get(i).getFechaIngreso();
                String nombreRegistroDispositivo = dispositivoDAO.consultarListaLaptops().get(i).getNombreRegistro();
                String estatusDispositivo = dispositivoDAO.consultarListaLaptops().get(i).getEstatus();
                Laptop laptop = new Laptop(claveDispositivo, descripcionDispostivo, estatusDispositivo, fechaIngresoDispostivo, nombreRegistroDispositivo);
                dispositivoDAO.cambiarEstatusPrestadoLaptop(laptop);  
            }
        }
        
        for (int i = 0; i < dispositivoDAO.consultarListaProyectores().size(); i++) {
            String claveDispositivoEsperada = dispositivoDAO.consultarListaProyectores().get(i).getClave();
            if (claveDispositivo.equals(claveDispositivoEsperada)) {
                String descripcionDispostivo = dispositivoDAO.consultarListaProyectores().get(i).getDescripcion();
                Date fechaIngresoDispostivo = new Date();
                fechaIngresoDispostivo = dispositivoDAO.consultarListaProyectores().get(i).getFechaIngreso();
                String nombreRegistroDispositivo = dispositivoDAO.consultarListaProyectores().get(i).getNombreRegistro();
                String estatusDispositivo = dispositivoDAO.consultarListaProyectores().get(i).getEstatus();
                Proyector proyector = new Proyector(claveDispositivo, descripcionDispostivo, estatusDispositivo, fechaIngresoDispostivo, nombreRegistroDispositivo);
                dispositivoDAO.cambiarEstatusPrestadoProyector(proyector);  
            }
        }
    }
    
    public void registrarNuevoPrestamo(ActionEvent actionEvent) {
        String lugarPrestamo = null;
        String nombrePrestario = null;
        String tipoPrestario = null;
        String numeroPersonalPrestatario = null; 
        
        boolean lugarPrestamoValido = false;
        boolean nombrePrestatarioValido = false;
        boolean tipoPrestatarioValido = false; 
        boolean numeroPersonalPrestatarioValido = false;
        
        if (comboBoxPrestamoTipoPrestatario.getSelectionModel().getSelectedItem() != null) {
            tipoPrestario = comboBoxPrestamoTipoPrestatario.getSelectionModel().getSelectedItem();
            tipoPrestatarioValido = true; 
        }
        
        if (!textFieldPrestamoLugarDispositivo.getText().isEmpty()) {
            lugarPrestamo = textFieldPrestamoLugarDispositivo.getText();
            lugarPrestamoValido = true;
        }
        
        if (!textFieldPrestamoNombrePrestatario.getText().isEmpty()) {
            nombrePrestario = textFieldPrestamoNombrePrestatario.getText();
            nombrePrestatarioValido = true;
        }
        
        if (!textFieldPrestamoClavePrestatario.getText().isEmpty()) {
            numeroPersonalPrestatario = textFieldPrestamoClavePrestatario.getText();
            numeroPersonalPrestatarioValido = true;
        } 
        
        String nombreRegistroPrestamo = labelNombreUsuarioCargado.getText();
        CamposInvalidosRegistroPrestamo camposInvalidosRegistroPrestamo = new CamposInvalidosRegistroPrestamo(lugarPrestamoValido, nombrePrestatarioValido, tipoPrestatarioValido, numeroPersonalPrestatarioValido);
        if (nombrePrestatarioValido && tipoPrestatarioValido && lugarPrestamoValido && numeroPersonalPrestatarioValido) {
            Prestatario prestatario = new Prestatario(nombrePrestario, tipoPrestario, numeroPersonalPrestatario);
            prestatarioDAO.registrarPrestatario(prestatario);
            int prestatarioId = 0;
            for (int i = 0; i < prestatarioDAO.consultarListaPrestarios().size(); i++) {
                String matriculaPrestarioEsperada = prestatarioDAO.consultarListaPrestarios().get(i).getMatricula(); 
                if (numeroPersonalPrestatario.equals(matriculaPrestarioEsperada)) {
                    prestatarioId = prestatarioDAO.consultarListaPrestarios().get(i).getPrestatarioId();
                }
            }
            String claveDispositivo = textFieldPrestamoClaveDispositivo.getText();
            Prestamo prestamo = new Prestamo(lugarPrestamo, convertToDate(datePickerPrestamoFecha.getValue()), claveDispositivo, prestatarioId, nombreRegistroPrestamo);
            cambiarEstatusDispositivoPrestado(claveDispositivo);
            prestatarioDAO.registrarPrestamo(prestamo);
            mostrarCamposInvalidosRegistroPrestamo(camposInvalidosRegistroPrestamo);
            mostrarGuiConfirmacionRegistroPrestamos();
        } else {
            mostrarCamposInvalidosRegistroPrestamo(camposInvalidosRegistroPrestamo);
            mostrarGuiCamposInvalidos();
        }
    }
 
    public void mostrarGuiCancelarAsignacionPrestamo(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelar asignación de Préstamos");        
        alert.setHeaderText("¿Desea cancelar la asignación del prestamo?");
        alert.setContentText("El préstamo no se asignará.");
        Optional<ButtonType> buttonCancelarRegistro = alert.showAndWait();
        if (buttonCancelarRegistro.get() == ButtonType.OK){
            salirAsignacionPrestamo();
            imageViewMenuLateral.setVisible(true);
        }
    }
    
    public void salirBusquedaDispositivo() {
        comboBoxFiltroBusqueda.getSelectionModel().clearSelection();
        tableViewBusquedaCable.setVisible(false);
        tableViewBusquedaConector.setVisible(false);
        tableViewBusquedaControl.setVisible(false);
        tableViewBusquedaLaptop.setVisible(false);
        tableViewBusquedaProyector.setVisible(false);
        tableViewBusquedaDispositivo.setVisible(false);
        anchorPaneBuscarDispositivo.setVisible(false);
    }
    
    public void salirAsignacionPrestamo() {
        textFieldPrestamoClaveDispositivo.setText("");
        textFieldPrestamoLugarDispositivo.setText("");
        datePickerPrestamoFecha.setValue(null);
        textFieldPrestamoNombrePrestatario.setText("");
        textFieldPrestamoClavePrestatario.setText("");
        quitarBordeCamposRegistroPrestamo();
        anchorPanePrestamoDispositivo.setVisible(false);
        anchorPaneCaractetisticasDispositivo.setVisible(false);
        salirBusquedaDispositivo();
    }
    
    @FXML
    public void mostrarGuiCancelarBusquedaDispositivo(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelar búsqueda de Dispositivo");        
        alert.setHeaderText("¿Desea cancelar la búsqueda?");
        Optional<ButtonType> buttonCancelarRegistro = alert.showAndWait();
        if (buttonCancelarRegistro.get() == ButtonType.OK){
            salirBusquedaDispositivo();
            imageViewMenuLateral.setVisible(true);
        }
    }
    
    
    /*-----------------------------------------------------*/
    
    
    @FXML
    public void mostrarGuiRegistrarDevolucionDispositivo() {
        Date date = new Date();
        convertToLocalDate(date);
        datePickerDevolucionFecha.setValue(convertToLocalDate(date));
        llenarComboBoxDispositivosPrestados();
        anchorPaneDevolucionDispositivo.setVisible(true);
    }
    
    public void quitarBordeRegistroDevolucion() {
        String fondoGris = "-fx-background-color: #ededed";
        String fondoBlanco = "-fx-background-color: #FFFFFF";
        String bordeRedondeado = "-fx-border-radius: 20";
        String fondoRedondeado = "-fx-background-radius: 20";
        String colorBorde = "-fx-border-color: #cfcfcf";
        
        comboBoxDevolucionClaveDispositivo.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
    }
    
    public void mostrarCamposInvalidosRegistroPrestamo(boolean claveDispositoValida ) {
        String bordeRojo = "-fx-background-color: #fcbdb8";
        String bordeVerde = "-fx-background-color: #bbfcb8";
        String fondoRedondeado = "-fx-background-radius: 20";
        
        if (!claveDispositoValida) {
            comboBoxDevolucionClaveDispositivo.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            comboBoxDevolucionClaveDispositivo.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
    }
    
    public void mostrarGuiConfirmacionRegistroDevolucion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmación de devolución");        
        alert.setHeaderText("El registro de devolución se llevo acabo correctamente!");
        alert.setContentText("La devolución se asignó correctamente");
        Optional<ButtonType> buttonAceptarRegistro = alert.showAndWait();
        if (buttonAceptarRegistro.get() == ButtonType.OK){
            salirAceptarDevolucion();
        }
    }
    
    public void llenarComboBoxDispositivosPrestados() {
        ObservableList<String> listaDispositivosPrestados = FXCollections.observableArrayList();
        for (int i = 0; i < dispositivoDAO.consultarTodosDispositivos().size(); i++) {
            String estatusEsperado = "Prestado";
            String estatusPrestado = dispositivoDAO.consultarTodosDispositivos().get(i).getEstatus();
            if (estatusPrestado.equals(estatusEsperado)) {
                listaDispositivosPrestados.add(dispositivoDAO.consultarTodosDispositivos().get(i).getClave());
            }
        }
        comboBoxDevolucionClaveDispositivo.setItems(listaDispositivosPrestados); 
    }
    
    public void registrarNuevaDevolucion(ActionEvent actionEvent) {
        String claveDispositivo = null;
        boolean claveDispositivoValida = false;
        
        if (comboBoxDevolucionClaveDispositivo.getSelectionModel().getSelectedItem() != null) {
            claveDispositivo = comboBoxDevolucionClaveDispositivo.getSelectionModel().getSelectedItem();
            claveDispositivoValida = true; 
        }
        
        String nombreRegistroDevolucion = labelNombreUsuarioCargado.getText();
        
        int idPrestatario = 0;
        String claveDispositivoEsperada = null;
        
        if (claveDispositivoValida) {
            for (int i = 0; i < prestamoDAO.consultarPrestamos().size(); i++) {
                claveDispositivoEsperada = prestamoDAO.consultarPrestamos().get(i).getClaveDispositivoPrestado();
                if (claveDispositivo.equals(claveDispositivoEsperada)) {
                    idPrestatario = prestamoDAO.consultarPrestamos().get(i).getPrestatarioId();
                }
            }
                        
            for (int i = 0; i < dispositivoDAO.consultarListaCables().size(); i++) {
                if (claveDispositivo.equals(dispositivoDAO.consultarListaCables().get(i).getClave())) {
                    dispositivoDAO.cambiarEstatusDisponibleCable(claveDispositivo);
                }
            }            
            
            for (int i = 0; i < dispositivoDAO.consultarListaConectores().size(); i++) {
                if (claveDispositivo.equals(dispositivoDAO.consultarListaConectores().get(i).getClave())) {
                    dispositivoDAO.cambiarEstatusDisponibleConector(claveDispositivo);
                }
            }

            for (int i = 0; i < dispositivoDAO.consultarListaControles().size(); i++) {
                if (claveDispositivo.equals(dispositivoDAO.consultarListaControles().get(i).getClave())) {
                    dispositivoDAO.cambiarEstatusDisponibleControl(claveDispositivo);
                }
            }
            for (int i = 0; i < dispositivoDAO.consultarListaLaptops().size(); i++) {
                if (claveDispositivo.equals(dispositivoDAO.consultarListaLaptops().get(i).getClave())) {
                    dispositivoDAO.cambiarEstatusDisponibleLaptop(claveDispositivo);
                }
            }
            for (int i = 0; i < dispositivoDAO.consultarListaProyectores().size(); i++) {
                if (claveDispositivo.equals(dispositivoDAO.consultarListaProyectores().get(i).getClave())) {
                    dispositivoDAO.cambiarEstatusDisponibleProyector(claveDispositivo);
                }
            }
            Date date = new Date();
            Devolucion devolucion = new Devolucion(date, claveDispositivo, idPrestatario, nombreRegistroDevolucion);
            devolucionDAO.registrarDevolucion(devolucion);
            mostrarCamposInvalidosRegistroPrestamo(claveDispositivoValida);
            mostrarGuiConfirmacionRegistroDevolucion();
        } else {
            mostrarCamposInvalidosRegistroPrestamo(claveDispositivoValida);
            mostrarGuiCamposInvalidos();
        }
    }
        
    public void salirAceptarDevolucion() {
        quitarBordeRegistroDevolucion();
        comboBoxDevolucionClaveDispositivo.getSelectionModel().clearSelection();
        anchorPaneDevolucionDispositivo.setVisible(false);
    }
    
    public void mostrarGuiCancelarAceptarDevolucion(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelar aceptación de devolución");        
        alert.setHeaderText("¿Desea cancelar el registro de devolución?");
        alert.setContentText("El registro de devolución no se registrará.");
        Optional<ButtonType> buttonCancelarRegistro = alert.showAndWait();
        if (buttonCancelarRegistro.get() == ButtonType.OK){
            salirAceptarDevolucion();
            imageViewMenuLateral.setVisible(true);
        }
    }
    
    
    /*------------------------------------------------------*/
    

    @FXML
    public void mostrarGuiAgregarRegistroMantenimiento() {
        anchorPaneRegistroMantenimiento.setVisible(true);
    }
    
    
    /*--------------------------------------------------------*/
    
    
    public void quitarBordeReporte() {
        String fondoGris = "-fx-background-color: #ededed";
        String fondoBlanco = "-fx-background-color: #FFFFFF";
        String bordeRedondeado = "-fx-border-radius: 20";
        String fondoRedondeado = "-fx-background-radius: 20";
        String colorBorde = "-fx-border-color: #cfcfcf";
        
        datePickerReporteFechaBusqueda.setStyle(fondoBlanco + "; " + bordeRedondeado + "; " + fondoRedondeado + "; " + colorBorde);
    }
    
    @FXML
    public void mostrarGuiObtenerRegistroVerificacion() {
        anchorPaneReporteVerficacion.setVisible(true);
        if (datePickerReporteFechaBusqueda.isDisable()) {
            Date date = new Date();
            convertToLocalDate(date);
            datePickerReporteFechaBusqueda.setValue(convertToLocalDate(date));
            
        }
    }
    
    public void mostrarFechaInvalidaReporte(boolean fechaInvalida) {
        String bordeRojo = "-fx-background-color: #fcbdb8";
        String bordeVerde = "-fx-background-color: #bbfcb8";
        String fondoRedondeado = "-fx-background-radius: 20";
        
        if (!fechaInvalida) {
            datePickerReporteFechaBusqueda.setStyle(bordeRojo + "; " + fondoRedondeado);
        } else {
            datePickerReporteFechaBusqueda.setStyle(bordeVerde + "; " + fondoRedondeado);
        }
    }
    
    public void consultarFechaReporte(ActionEvent actionEvent) {
        boolean fechaValida = false; 
        
        if (datePickerReporteFechaBusqueda.getValue() != null) {
            fechaValida = true;
        }
        
        if (fechaValida) {
            ObservableList<Prestamo> prestamos = FXCollections.observableArrayList();
            for (int i = 0; i < prestamoDAO.consultarPrestamos().size(); i++) {
                if (convertToDate(datePickerReporteFechaBusqueda.getValue()).equals(prestamoDAO.consultarPrestamos().get(i).getFechaPrestamo())) {
                    prestamos.add(prestamoDAO.consultarPrestamos().get(i));
                }
            }
            tableColumnReporteClave.setCellValueFactory(new PropertyValueFactory("claveDispositivoPrestado"));
            tableColumnReporteFecha.setCellValueFactory(new PropertyValueFactory("fechaPrestamo"));
            tableColumnReporteLugar.setCellValueFactory(new PropertyValueFactory("lugar"));
            tableColumnReporteResponsable.setCellValueFactory(new PropertyValueFactory("nombreRegistra"));
            tableViewReportePrestamos.setItems(prestamos);
            
            ObservableList<Devolucion> devoluciones = FXCollections.observableArrayList();
            for (int i = 0; i < devolucionDAO.consultarListaDevoluciones().size(); i++) {
                if (convertToDate(datePickerReporteFechaBusqueda.getValue()).equals(devolucionDAO.consultarListaDevoluciones().get(i).getFechaDevolucion())) {
                    devoluciones.add(devolucionDAO.consultarListaDevoluciones().get(i));
                }
            }
            tableColumnDevolucionesClave.setCellValueFactory(new PropertyValueFactory("claveDispositivo"));
            tableColumnDevolucionesFecha.setCellValueFactory(new PropertyValueFactory("fechaDevolucion"));
            tableColumnDevolucionesResponsable.setCellValueFactory(new PropertyValueFactory("nombreRegistro"));
            tableViewDevoluciones.setItems(devoluciones);
            
            tableViewReportePrestamos.refresh();
            tableViewDevoluciones.refresh();
            mostrarFechaInvalidaReporte(fechaValida);
            
        } else {
            mostrarFechaInvalidaReporte(fechaValida);
            mostrarGuiCamposInvalidos();
        }
    }
    
    public void salirVerificacionReporte() {
        tableViewDevoluciones.getItems().clear();
        tableViewReportePrestamos.getItems().clear();
        datePickerReporteFechaBusqueda.setValue(null);
        quitarBordeReporte();
        anchorPaneReporteVerficacion.setVisible(false);
    }

    public void mostrarGuiCancelarSalir(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir");        
        alert.setHeaderText("¿Desea salir de la verificación del registro?");
        alert.setContentText("El reporte de verificación no se guardará.");
        Optional<ButtonType> buttonCancelarRegistro = alert.showAndWait();
        if (buttonCancelarRegistro.get() == ButtonType.OK){
            salirVerificacionReporte();
            imageViewMenuLateral.setVisible(true);
        }
    }
}