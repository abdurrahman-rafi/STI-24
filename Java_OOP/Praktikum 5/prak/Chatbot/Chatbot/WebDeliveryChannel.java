public class WebDeliveryChannel implements DeliveryChannel{
    // TODO:
    // Kelas ini harus mengimplementasikan interface Delivery channel

    @Override 
    public String deliver(String response, Chatbot chatbot){
        if(response == null){
            return "";
        }

        return ("[WebWidget] " + chatbot.getName() + ": " + response);
    }
    // TODO:
    // Kelas ini harus method deliver dari DeliveryChannel dengan ketentuan:
    // 1. Ketika responsenya adalah null maka return string kosong ("")
    // 2. Ketika responsenya valid, return: "[WebWidget] <chatbot name>: <response>"
}
