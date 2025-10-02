class GamingConsole implements IGadget {
  private String brand;
  private String model;
  private double price;
  private boolean isOn;

  /* Konstruktor */
  public GamingConsole(String brand, String model, double price) {
    this.brand = brand;
    this.model = model;
    this.price = price;
    this.isOn = false;
    System.out.println("Gaming Console " + brand + " " + model + " created.");
  }


  // Gaming Console specific method
  /**
   * Memainkan game pada konsol
   * Menampilkan pesan "Playing [gameName] on [brand] [model]"
   * 
   * @param gameName
   */
  public void playGame(String gameName) {
    System.out.println(String.format("Playing [%s] on [%s] [%s]", gameName, getBrand(), model));
  }

  /**
   * Menghidupkan gadget
   * 
   * Mengubah status isOn menjadi true
   * 
   * Menampilkan pesan "[brand] [model] is now ON"
   */
  @Override
  public void turnOn(){
    isOn = true;
    System.out.println(String.format("[%s] [%s] is now ON",getBrand(), getModel()));
  }

  /**
   * Mematikan gadget
   * 
   * Mengubah status isOn menjadi false
   * 
   * Menampilkan pesan "[brand] [model] is now OFF"
   */
  @Override
  public void turnOff(){
    isOn = false;
    System.out.println(String.format("[%s] [%s] is now OFF",getBrand(), getModel()));
  }

  /**
   * Mendapatkan informasi gadget
   * 
   * Jika gadget menyala, mengembalikan string dalam format:
   * "[ON] [brand] [model] - Rp [price]"
   * 
   * Jika gadget mati, mengembalikan string dalam format:
   * "[OFF] [brand] [model] - Rp [price]"
   */
  @Override
  public String getInfo(){
    String onoff = (isOn) ? "ON" : "OFF";
    return String.format("[%s] [%s] [%s] - Rp %1f", onoff, getBrand(), getModel(), getPrice());
  }

  /**
   * Mendapatkan harga gadget
   * 
   * @return harga gadget
   */
  @Override
  public double getPrice(){
    return price;
  }

  /**
   * Mendapatkan merek gadget
   * 
   * @return merek gadget
   */
  @Override
  public String getBrand(){
    return brand;
  }

  public String getModel(){
    return model;
  }
}