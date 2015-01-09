package PageDevice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Include;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Window;

import wizardUtil.WizardContext;
import wizardUtil.WizardPanel;

public class WizardTemp extends SelectorComposer<Component>{
    	@Wire("#winModal")
	private Window winModal;
	
	@Wire("#midleContent")
	private Div midleContent;
	
	private int numPage=0;
	@Wire("#nextButton")
	private Button nextButton;
	@Wire("#backButton")
	private Button backButton;
	@Wire("#cancelButton")
	private Button cancelButton;
	
	//private Button helpButton=new Button("help");
	//private final HashMap listener=new HashMap();
	//private Stack previus =null;
	//private WizardPanel current=null;
	//private WizardContext ctx=null;
	//private Map i18n=null;
	
	public WizardTemp() {
	    //this.nextButton.setDisabled(false);
    	    //this.cancelButton.setDisabled(false);
    	    //this.backButton.setDisabled(true);
	    //winModal.getChildren().
	    
	   // Clients.showNotification(nextButton.getLabel());
	}
        @Wire("#optionDevice")
        	Radiogroup optionDevice;
        	
        public void doAfterCompose(Component comp) throws Exception {
            	super.doAfterCompose(comp);
            	Clients.showNotification("se esta ejecutando compose");
        	this.nextButton.setDisabled(false);
        	this.cancelButton.setDisabled(false);
        	this.backButton.setDisabled(true);
        }
        

	@Listen("onCheck=#optionDevice")
	public void onChangeOption(){
		String name;
		name=optionDevice.getSelectedItem().getLabel();
		Clients.showNotification("item selected"+name,true);
	}
	
	@Listen("onClick=#nextButton")
	public void nextAction() {
	    //numPage++;
	    Clients.showNotification("next");
	    midleContent.getChildren().clear();
	    //Clients.showNotification(""+optionDevice.getChildren());
	    //Clients.showNotification(""+optionDevice.getSelectedItem().getValue());
	    changePage();
	}
	
	@Listen("onClick=#backButton")
	public void backAction() {
	    numPage--;
	    Clients.showNotification("back");
	    
	}
	@Listen("onClick=#cancelButton")
	public void cancelAction() {
	    Clients.showNotification("Cancel");
	    winModal.detach();
	}
	
	private void changePage() {
		Clients.showNotification("se esta haciendo algo");
		try{
			 Include page=new Include("./newDeviceManual.zul");
			    //switch(numPage) {
			    /*
			    case 1:
				int a=optionDevice.getSelectedItem().getValue();
				if(a==0) {
				    page.setSrc("newDeviceManual.zul");
				}else if(a==1) {
				    page.setSrc("newDeviceByIP.zul");
				}*/
			    
				Clients.showNotification(""+page.getSrc());
				midleContent.appendChild(page);
		}catch(Exception ex){
			Clients.showNotification(""+Arrays.toString(ex.getStackTrace()), true);
		}
	   
		//break;
		
	    //}
	}
	
	@Listen("onCancel=#winModal")
	public void onCancel() {
	    winModal.detach();
	}
}
