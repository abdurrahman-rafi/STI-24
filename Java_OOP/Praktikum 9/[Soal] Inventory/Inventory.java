  import java.util.*;

  public class Inventory {
    /*
    * Inventory class to manage a grid-based inventory system.
    * 
    * Inventory Example:
    * A1 | A2 | A3 | A4
    * B1 | B2 | B3 | B4
    * C1 | C2 | C3 | C4
    * D1 | D2 | D3 | D4
    * E1 | E2 | E3 | E4
    * 
    * Row 0, Col 0 -> A1
    * Row 1, Col 2 -> B3
    * etc.
    */

    public Map<String, Item> grid; // Key format: "A1", "B3", etc.
    private int rows;
    private int cols;
    private double maxWeight;
    private double currentWeight;

    /**
     * Constructor
     * 
     * Creates an inventory grid with specified rows and columns and maximum weight
     * capacity.
     * 
     * Hint:
     * - Use LinkedLinkedHashMap to maintain insertion order for grid positions.
     * - Initialize grid using initializeGrid() method.
     * 
     * @param rows
     * @param cols
     * @param maxWeight
     */
    public Inventory(int rows, int cols, double maxWeight) {
      grid = new LinkedHashMap(rows * cols);
      
      this.rows = rows;
      this.cols = cols;
      initializeGrid();
      this.maxWeight = maxWeight;
      currentWeight = 0;
    }

    /**
     * Initialize grid with empty slots
     * 
     * Hint:
     * - Use nested loops to create keys for each grid position.
     * - Set each position to null (indicating empty).
     */
    private void initializeGrid() {
      for(int i  = 0; i < rows; i++){
        int ascii = 65 + i;
        char curr = (char) ascii;
        for(int j = 0; j < cols; j++){
          String current = curr + "" + (j+1);
          grid.put(current, null);
        }
      }
    }

    /**
     * Get key for given row and column
     * 
     * Row 0, Col 0 -> A1
     * Row 1, Col 2 -> B3
     * 
     * @param row
     * @param col
     * @return key representation of position. e.g. "A1", "B3", etc.
     */
    private String getKey(int row, int col) {
      int ascii = 65 + row;
      int num = col + 1;
      char chars = (char) ascii;
      return chars + "" + num;
    }

    /**
     * Check if key is valid
     * 
     * Hint:
     * - Check if the key exists in the grid map.
     * 
     * @param key
     * @return key validation result
     */
    private boolean isValidKey(String key) {
      return grid.containsKey(key);
    }

    /**
     * Add item to specific position
     * 
     * Hint:
     * - Check if position is valid, if not return false.
     * - Check if position is empty, if not return false.
     * - Check if adding the item exceeds max weight, if so return false.
     * - If all checks pass, add item to grid at position.
     * - Update current weight accordingly and print "Added <item_name> to position
     * <position>".
     * - Return true if item added successfully.
     * 
     * @param position
     * @param item
     * @return success status
     */
    public boolean addItem(String position, Item item) {
      if(isValidKey(position)){
        if(grid.get(position) == null){
          if(getCurrentWeight() + item.getWeight() <= getMaxWeight()){
            grid.put(position, item);
            currentWeight += item.getWeight() * item.getQuantity();
            System.out.println("Added " + item.getName() + " to position " + position);
            return true;
          }
        }
      }
      return false;
    }

    /**
     * Remove item from specific position
     * 
     * Hint:
     * - Check if position is valid, if not return null.
     * - Check if position is empty, if so return null.
     * - If item exists, remove it from grid and update current weight.
     * - Print "Removed <item_name> from position <position>".
     * - Return the removed item.
     * 
     * @param position
     * @return removed item or null if not found
     */
    public Item removeItem(String position) {
      if(isValidKey(position)){
        if(grid.get(position) != null){

            Item item = grid.get(position);
            currentWeight -= item.getWeight();
            System.out.println("Removed " + item.getName() + " from position " + position);
            grid.put(position,null);
            return item;
          
        }
      }
      return null;
    }

    /**
     * Move item from one position to another
     * 
     * Hint:
     * - Remove item from 'from' position.
     * - If no item found, return false.
     * - Try to add item to 'to' position.
     * - If adding fails, put item back to 'from' position and return false.
     * - If successful, return true.
     * 
     * @param from
     * @param to
     * @return success status
     */
    public boolean moveItem(String from, String to) {
      Item item = removeItem(from);
      if(item == null){
        return false;
      }
      return addItem(to, item);
    }

    /**
     * Get all items (using Collection)
     * 
     * Hint:
     * - Iterate through grid values and filter non-null items.
     * - Collect and return as a Collection<Item>.
     * 
     * @return collection of all items
     */
    public Collection<Item> getAllItems() {
      Collection<Item> collections = new ArrayList<Item>();
      for(Map.Entry<String, Item> entry : grid.entrySet() ){
        if(entry.getValue() != null){
          collections.add(entry.getValue());
        }
        
      }
      return collections;
    }

    /**
     * Get all occupied positions (using Collection)
     * 
     * Hint:
     * - Iterate through grid entries and filter non-null items.
     * - Add their keys to a Set<String>.
     * 
     * @return set of occupied positions
     */
    public Set<String> getOccupiedPositions() {
      Set<String> set = new HashSet<String>();
      for(Map.Entry<String, Item> entry : grid.entrySet() ){
        if(entry.getValue() != null){
          set.add(entry.getKey());
        }
        
      }
      return set;
    }

    /**
     * Search items by name (using Collection)
     * 
     * Hint:
     * - Iterate through grid entries and filter non-null items.
     * - Filter items whose names contain the search term (case-insensitive).
     * - Collect and return as a Map<String, Item> with position as key.
     * 
     * @param name
     * @return Map of positions to items matching the name
     */
    public Map<String, Item> searchByName(String name) {
      Map<String, Item> map = new LinkedHashMap<String,Item>();

      for(Map.Entry<String, Item> entry : grid.entrySet() ){
        if(entry.getValue() != null){
          if(entry.getValue().getName().contains(name)){
            map.put(entry.getKey(), entry.getValue());
          }
        }
        
        
      }
      return map;
    }

    /**
     * Filter by type (using Collection)
     * 
     * Hint:
     * - Iterate through grid entries and filter non-null items.
     * - Filter items whose type matches the given type (case-insensitive).
     * - Collect and return as a Map<String, Item> with position as key.
     * 
     * @param type
     * @return Map of positions to items matching the type
     */
    public Map<String, Item> filterByType(String type) {
      Map<String, Item> map = new LinkedHashMap<String, Item>();

      for(Map.Entry<String, Item> entry : grid.entrySet() ){
        if(entry.getValue() != null && entry.getValue().getType().equalsIgnoreCase(type)){
          map.put(entry.getKey(), entry.getValue());
        }
        
      }

      return map;
    }

    /**
     * Filter by rarity (using Collection)
     * 
     * Hint:
     * - Iterate through grid entries and filter non-null items.
     * - Filter items whose rarity is greater than or equal to minRarity.
     * - Collect and return as a Map<String, Item> with position as key.
     * 
     * @param minRarity
     * @return Map of positions to items matching the rarity
     */
    public Map<String, Item> filterByRarity(int minRarity) {
      Map<String, Item> map = new LinkedHashMap<String, Item>();

      for(Map.Entry<String, Item> entry : grid.entrySet() ){
        if(entry.getValue() != null && entry.getValue().getRarity() >= minRarity){
          map.put(entry.getKey(), entry.getValue());
        }
        
      }

      return map;
    }

    /**
     * Filter by weight range (using Collection)
     * 
     * Hint:
     * - Iterate through grid entries and filter non-null items.
     * - Filter items whose weight is within the specified range.
     * - Collect and return as a Map<String, Item> with position as key.
     * 
     * @param minWeight
     * @param maxWeight
     * @return Map of positions to items within the weight range
     */
    public Map<String, Item> filterByWeightRange(double minWeight, double maxWeight) {
      Map<String, Item> map = new LinkedHashMap<String, Item>();

      for(Map.Entry<String, Item> entry : grid.entrySet() ){
        if(entry.getValue() != null){
          double weight = entry.getValue().getWeight();
        if(weight >= minWeight && weight <= maxWeight){
          map.put(entry.getKey(), entry.getValue());
        }
        }
      }

      return map;
    }

    /**
     * Sort items by name (using Collection)
     * 
     * Hint:
     * - Filter non-null items from grid entries.
     * - Sort items by name alphabetically using Collections.sort().
     * - Return as a List<Map.Entry<String, Item>>.
     * 
     * @return List of entries sorted by item name
     */
    public List<Map.Entry<String, Item>> sortByName() {
      List<Map.Entry<String, Item>> list = new ArrayList<>();
      for(Map.Entry<String, Item> entry : grid.entrySet() ){
        if(entry.getValue() != null){
          list.add(entry);
        }
      }

      list.sort(Comparator.comparing(e -> e.getValue().getName(),String.CASE_INSENSITIVE_ORDER));

      return list;
    }

    /**
     * Sort items by rarity (descending) (using Collection)
     * 
     * Hint:
     * - Filter non-null items from grid entries.
     * - Sort items by rarity in descending order using Collections.sort().
     * - Return as a List<Map.Entry<String, Item>>.
     * 
     * @return List of entries sorted by item rarity
     */
    public List<Map.Entry<String, Item>> sortByRarity() {
      List<Map.Entry<String, Item>> list = new ArrayList<>();
      for(Map.Entry<String, Item> entry : grid.entrySet() ){
        if(entry.getValue() != null){
          list.add(entry);
        }
      }

      list.sort(Comparator.comparingInt((Map.Entry<String, Item> e) -> e.getValue().getRarity()).reversed());

      return list;
    }

    /**
     * Sort items by weight (using Collection)
     * 
     * Hint:
     * - Filter non-null items from grid entries.
     * - Sort items by weight in ascending order using Collections.sort().
     * - Return as a List<Map.Entry<String, Item>>.
     * 
     * @return List of entries sorted by item weight
     */
    public List<Map.Entry<String, Item>> sortByWeight() {
      List<Map.Entry<String, Item>> list = new ArrayList<>();
      for(Map.Entry<String, Item> entry : grid.entrySet() ){
        if(entry.getValue() != null){
          list.add(entry);
        }
      }

      list.sort(Comparator.comparingDouble(e -> e.getValue().getWeight()));

      return list;
    }

    /**
     * Sort items by quantity (using Collection)
     * 
     * Hint:
     * - Filter non-null items from grid entries.
     * - Sort items by quantity in descending order using Collections.sort().
     * - Return as a List<Map.Entry<String, Item>>.
     * 
     * @return List of entries sorted by item quantity
     */
    public List<Map.Entry<String, Item>> sortByQuantity() {
      List<Map.Entry<String, Item>> list = new ArrayList<>();
      for(Map.Entry<String, Item> entry : grid.entrySet() ){
        if(entry.getValue() != null){
          list.add(entry);
        }
      }

      list.sort(Comparator.comparingInt((Map.Entry<String, Item> e) -> e.getValue().getQuantity()).reversed());

      return list;
    }

    /**
     * Get items by type count (using Collection)
     * 
     * Hint:
     * - Use getAllItems() to get collection of items.
     * - Iterate through items and count them by type.
     * - Return as a Map<String, Long>.
     * 
     * @return Map of item types to their counts
     */
    public Map<String, Long> getTypeStatistics() {
      Map<String, Long> typeCount = new LinkedHashMap<String,Long>();
      Collection<Item> items = getAllItems();
      for(Item i : items){
        String type = i.getType();
        typeCount.merge(type, 1L, Long::sum);
      }

      return typeCount;
    }

    /**
     * Get rarity distribution (using Collection)
     * 
     * Hint:
     * - Use getAllItems() to get collection of items.
     * - Iterate through items and count them by rarity.
     * - Return as a Map<Integer, Long>.
     * 
     * @return Map of item rarities to their counts
     */
    public Map<Integer, Long> getRarityDistribution() {
      Map<Integer, Long> rareCount = new LinkedHashMap<Integer,Long>();
      Collection<Item> items = getAllItems();
      for(Item i : items){
        int rarity = i.getRarity();
        rareCount.merge(rarity, 1L, Long::sum);
      }

      return rareCount;
    }

    /**
     * Get total quantity by type (using Collection)
     * 
     * Hint:
     * - Use getAllItems() to get collection of items.
     * - Iterate through items and sum their quantities by type.
     * - Return as a Map<String, Integer>.
     * 
     * @return Map of item types to their total quantities
     */
    public Map<String, Integer> getTotalQuantityByType() {
      Map<String, Integer> typeSum = new LinkedHashMap<String,Integer>();
      Collection<Item> items = getAllItems();
      for(Item i : items){
        String type = i.getType();
        int quantity = i.getQuantity();
        typeSum.merge(type, quantity, Integer::sum);
      }

      return typeSum;
      
    }

    /**
     * Get heaviest items (top N) (using Collection)
     * 
     * Hint:
     * - Filter non-null items from grid entries.
     * - Sort items by weight in descending order using Collections.sort().
     * - Limit to top N items using subList().
     * - Return as a List<Map.Entry<String, Item>>.
     * 
     * @param topN
     * @return List of entries of the heaviest items
     */
    public List<Map.Entry<String, Item>> getHeaviestItems(int topN) {
      List<Map.Entry<String, Item>> sortByWeight = sortByWeight();
      Collections.reverse(sortByWeight);
      List<Map.Entry<String, Item>> heaviest = sortByWeight.subList(0, Math.min(topN, sortByWeight.size()));
      return heaviest;
    }

    /**
     * Get lightest items (top N) (using Collection)
     * 
     * Hint:
     * - Filter non-null items from grid entries.
     * - Sort items by weight in ascending order using Collections.sort().
     * - Limit to top N items using subList().
     * - Return as a List<Map.Entry<String, Item>>.
     * 
     * @param topN
     * @return List of entries of the lightest items
     */
    public List<Map.Entry<String, Item>> getLightestItems(int topN) {
      List<Map.Entry<String, Item>> sortByWeight = sortByWeight().subList(0, Math.min(topN, sortByWeight().size()));
      return sortByWeight;
    }

    /**
     * Get legendary items (rarity 5) (using Collection)
     * 
     * Hint:
     * - Iterate through grid entries and filter non-null items.
     * - Filter items whose rarity is 5.
     * - Return as a List<Map.Entry<String, Item>>.
     * 
     * @return List of entries of legendary items
     */
    public List<Map.Entry<String, Item>> getLegendaryItems() {
      List<Map.Entry<String, Item>> legs = new ArrayList<>();

      for (Map.Entry<String, Item> e : grid.entrySet()) {
        if(e.getValue() != null && e.getValue().getRarity() == 5){
          legs.add(e);
        }
      }

      return legs;
    }

    /**
     * Check if inventory has item by name (using Collection)
     * 
     * Hint:
     * - Use getAllItems() to get collection of items.
     * - Iterate through items to check if any item's name matches the given name
     * (case-insensitive).
     * - Return true if found, false otherwise.
     * 
     * @param itemName
     * @return presence status
     */
    public boolean hasItem(String itemName) {
      Collection<Item> items = getAllItems();

      for(Item i : items){
        if(i.getName().equalsIgnoreCase(itemName)){
          return true;
        }
      }
      return false;
    }

    /**
     * Count total items
     * 
     * Hint:
     * - Use getAllItems() to get collection of items.
     * - Return the size of the collection.
     * 
     * @return total item count
     */
    public long countItems() {
      Collection<Item> items = getAllItems();

      return items.size();
    }

    /**
     * Count empty slots
     * 
     * Hint:
     * - Iterate through grid values and count null items.
     * - Return the number of empty slots.
     * 
     * @return empty slot count
     */
    public long countEmptySlots() {
      long count = 0;
      for(Map.Entry<String, Item> e : grid.entrySet()){
        if(e.getValue() == null){
          count++;
        }
      }
      return count;
    }

    /**
     * Get average weight of items (using Collection)
     * 
     * Hint:
     * - Use getAllItems() to get collection of items.
     * - Iterate through items and sum their weights.
     * - Calculate and return the average weight.
     * 
     * @return average item weight
     */
    public double getAverageItemWeight() {
      Collection<Item> items = getAllItems();
      if(items.isEmpty()){
        return 0.0;
      }
      double sum = 0;
      for(Item i : items){
        sum += i.getWeight();
      }

      return (double) (sum/items.size());
    }

    /**
     * Get average rarity (using Collection)
     * 
     * Hint:
     * - Use getAllItems() to get collection of items.
     * - Iterate through items and sum their rarities.
     * - Calculate and return the average rarity.
     * 
     * @return average item rarity
     */
    public double getAverageRarity() {
      Collection<Item> items = getAllItems();
      double sum = 0;
      for(Item i : items){
        sum += i.getRarity();
      }

      return (double) (sum/items.size());
    }

    /**
     * Stack similar items (using Collection)
     * 
     * Hint:
     * - Iterate through grid entries and group items by name. Use Map<String,
     * List<Map.Entry<String, Item>>> as temp storage. (item name, list of entries
     * with the same name)
     * - For each group with more than one item, sum their quantities.
     * - Update the first item's quantity
     * - Set others to null by iterating entries inside group except the first one
     * - Print "Stacked X instances of <item_name>" for each stacked item.
     */
    public void stackSimilarItems() {
      Map<String, List<Map.Entry<String,Item>>> stacks = new LinkedHashMap<>();
      for(Map.Entry<String, Item> e : grid.entrySet()){
        if(e.getValue() != null){
          String name = e.getValue().getName();
          stacks.putIfAbsent(name, new ArrayList<>());
          stacks.get(name).add(e);
        }
      }

      for(Map.Entry<String, List<Map.Entry<String,Item>>> s : stacks.entrySet()){
        List<Map.Entry<String, Item>> list = s.getValue();
        if(list.size() > 1){
          int total = 0;

          for(Map.Entry<String,Item> e : list){
            total += e.getValue().getQuantity();
          }

          list.get(0).getValue().setQuantity(total);

          for(int i = 1; i<list.size(); i++){
            grid.put(list.get(i).getKey(), null);
          }

          System.out.println("Stacked " + list.size() +" instances of " + s.getKey());
        }
      }


    }

    /**
     * Get first empty slot
     * 
     * Hint:
     * - Iterate through grid entries to find null items.
     * - Return the key of the first empty slot or null if none found.
     * 
     * @return key of first empty slot or null if none found
     */
    public String getFirstEmptySlot() {
      for(Map.Entry<String,Item> e : grid.entrySet()){
        if(e.getValue() == null){
          return e.getKey();
        }
      }

      return null;
    }

    /**
     * Auto-add item to first empty slot
     * 
     * Hint:
     * - Use getFirstEmptySlot() to find an empty position.
     * - If no empty slot, print "No empty slots available!" and return false.
     * - Otherwise, use addItem() to add the item to that position.
     * 
     * @param item
     * @return success status
     */
    public boolean autoAddItem(Item item) {
      String pos = getFirstEmptySlot();
      if(pos == null){
        System.out.println("No empty slots available!");
        return false;

      }

      return addItem(pos, item);
    }

    /**
     * Display inventory grid
     */
    public void displayGrid() {
      System.out.println("\n=== INVENTORY GRID ===");
      System.out.println("Capacity: " + countItems() + "/" + (rows * cols) + " slots");
      System.out.println("Weight: " + String.format("%.1f", currentWeight) + "/" +
          String.format("%.1f", maxWeight) + " kg");
      System.out.println();

      // Header
      System.out.print("    ");
      for (int col = 0; col < cols; col++) {
        System.out.printf("%-15s", (col + 1));
      }
      System.out.println();
      System.out.print("   ");
      for (int i = 0; i < cols * 15; i++) {
        System.out.print("-");
      }
      System.out.println();

      // Grid
      for (int row = 0; row < rows; row++) {
        char rowLabel = (char) ('A' + row);
        System.out.printf("%c | ", rowLabel);

        for (int col = 0; col < cols; col++) {
          String key = getKey(row, col);
          Item item = grid.get(key);

          if (item == null) {
            System.out.printf("%-15s", "[Empty]");
          } else {
            String display = item.getName().substring(0, Math.min(12, item.getName().length()));
            System.out.printf("%-15s", display);
          }
        }
        System.out.println();
      }
      System.out.println();
    }

    // Display detailed inventory
    public void displayDetailedInventory() {
      System.out.println("\n=== DETAILED INVENTORY ===");
      List<Map.Entry<String, Item>> items = new ArrayList<>();

      for (Map.Entry<String, Item> entry : grid.entrySet()) {
        if (entry.getValue() != null) {
          items.add(entry);
        }
      }

      Collections.sort(items, new Comparator<Map.Entry<String, Item>>() {
        @Override
        public int compare(Map.Entry<String, Item> e1, Map.Entry<String, Item> e2) {
          return e1.getKey().compareTo(e2.getKey());
        }
      });

      if (items.isEmpty()) {
        System.out.println("Inventory is empty!");
        return;
      }

      for (Map.Entry<String, Item> entry : items) {
        System.out.printf("[%s] %s\n", entry.getKey(), entry.getValue());
      }
      System.out.println();
    }

    // Display statistics
    public void displayStatistics() {
      System.out.println("\n=== INVENTORY STATISTICS ===");
      System.out.println("Total Items: " + countItems());
      System.out.println("Empty Slots: " + countEmptySlots());
      System.out.println("Current Weight: " + String.format("%.1f", currentWeight) + " kg");
      System.out.println("Average Item Weight: " + String.format("%.1f", getAverageItemWeight()) + " kg");
      System.out.println("Average Rarity: " + String.format("%.2f", getAverageRarity()) + "*");

      System.out.println("\n--- Items by Type ---");
      Map<String, Long> typeStats = getTypeStatistics();
      typeStats.forEach((type, count) -> System.out.println(type + ": " + count + " items"));

      System.out.println("\n--- Rarity Distribution ---");
      Map<Integer, Long> rarityDist = getRarityDistribution();
      for (int i = 1; i <= 5; i++) {
        long count = rarityDist.getOrDefault(i, 0L);
        System.out.println(i + "*: " + count + " items");
      }
      System.out.println();
    }

    public double getCurrentWeight() {
      return currentWeight;
    }

    public double getMaxWeight() {
      return maxWeight;
    }

    public int getRows() {
      return rows;
    }

    public int getCols() {
      return cols;
    }
  }
