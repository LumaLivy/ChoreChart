/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package net.sudormrf.chorechart;
import android.content.Intent;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.*;

// line 100 "../../../class.ump"
public class Facade
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Facade theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Facade Attributes
  private FirebaseDatabase database;
  private DatabaseReference userRef;
  private DatabaseReference shoppingRef;
  private DatabaseReference taskRef;
  private Home currentHome;
  private User currentUser;

  //Facade Associations
  private List<User> users;
  private List<Task> tasks;
  private List<Tools> tools;
  private List<ShoppingList> shoppingLists;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private Facade()
  {
    database = FirebaseDatabase.getInstance();
    userRef = database.getReference("users");
    shoppingRef = database.getReference("shopping");
    taskRef = database.getReference("tasks");
    currentHome = new Home("Test Home");
    currentUser = null;
    users = new ArrayList<User>();
    tasks = new ArrayList<Task>();
    tools = new ArrayList<Tools>();
    shoppingLists = new ArrayList<ShoppingList>();
  }

  public static Facade getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new Facade();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDatabase(FirebaseDatabase aDatabase)
  {
    boolean wasSet = false;
    database = aDatabase;
    wasSet = true;
    return wasSet;
  }

  public boolean setUserRef(DatabaseReference aUserRef)
  {
    boolean wasSet = false;
    userRef = aUserRef;
    wasSet = true;
    return wasSet;
  }

  public boolean setShoppingRef(DatabaseReference aShoppingRef)
  {
    boolean wasSet = false;
    shoppingRef = aShoppingRef;
    wasSet = true;
    return wasSet;
  }

  public boolean setTaskRef(DatabaseReference aTaskRef)
  {
    boolean wasSet = false;
    taskRef = aTaskRef;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentHome(Home aCurrentHome)
  {
    boolean wasSet = false;
    currentHome = aCurrentHome;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentUser(User aCurrentUser)
  {
    boolean wasSet = false;
    currentUser = aCurrentUser;
    wasSet = true;
    return wasSet;
  }

  public FirebaseDatabase getDatabase()
  {
    return database;
  }

  public DatabaseReference getUserRef()
  {
    return userRef;
  }

  public DatabaseReference getShoppingRef()
  {
    return shoppingRef;
  }

  public DatabaseReference getTaskRef()
  {
    return taskRef;
  }

  public Home getCurrentHome()
  {
    return currentHome;
  }

  public User getCurrentUser()
  {
    return currentUser;
  }

  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
  }

  public Task getTask(int index)
  {
    Task aTask = tasks.get(index);
    return aTask;
  }

  public List<Task> getTasks()
  {
    List<Task> newTasks = Collections.unmodifiableList(tasks);
    return newTasks;
  }

  public int numberOfTasks()
  {
    int number = tasks.size();
    return number;
  }

  public boolean hasTasks()
  {
    boolean has = tasks.size() > 0;
    return has;
  }

  public int indexOfTask(Task aTask)
  {
    int index = tasks.indexOf(aTask);
    return index;
  }

  public Tools getTool(int index)
  {
    Tools aTool = tools.get(index);
    return aTool;
  }

  public List<Tools> getTools()
  {
    List<Tools> newTools = Collections.unmodifiableList(tools);
    return newTools;
  }

  public int numberOfTools()
  {
    int number = tools.size();
    return number;
  }

  public boolean hasTools()
  {
    boolean has = tools.size() > 0;
    return has;
  }

  public int indexOfTool(Tools aTool)
  {
    int index = tools.indexOf(aTool);
    return index;
  }

  public ShoppingList getShoppingList(int index)
  {
    ShoppingList aShoppingList = shoppingLists.get(index);
    return aShoppingList;
  }

  public List<ShoppingList> getShoppingLists()
  {
    List<ShoppingList> newShoppingLists = Collections.unmodifiableList(shoppingLists);
    return newShoppingLists;
  }

  public int numberOfShoppingLists()
  {
    int number = shoppingLists.size();
    return number;
  }

  public boolean hasShoppingLists()
  {
    boolean has = shoppingLists.size() > 0;
    return has;
  }

  public int indexOfShoppingList(ShoppingList aShoppingList)
  {
    int index = shoppingLists.indexOf(aShoppingList);
    return index;
  }

  public static int minimumNumberOfUsers()
  {
    return 0;
  }

  public User addUser(String aName, Home aHome)
  {
    return new User(aName, aHome, this);
  }

  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    Facade existingFacade = aUser.getFacade();
    boolean isNewFacade = existingFacade != null && !this.equals(existingFacade);
    if (isNewFacade)
    {
      aUser.setFacade(this);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    //Unable to remove aUser, as it must always have a facade
    if (!this.equals(aUser.getFacade()))
    {
      users.remove(aUser);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTasks()
  {
    return 0;
  }

  public Task addTask(String aName, String aDeadline)
  {
    return new Task(aName, aDeadline, this);
  }

  public boolean addTask(Task aTask)
  {
    boolean wasAdded = false;
    if (tasks.contains(aTask)) { return false; }
    Facade existingFacade = aTask.getFacade();
    boolean isNewFacade = existingFacade != null && !this.equals(existingFacade);
    if (isNewFacade)
    {
      aTask.setFacade(this);
    }
    else
    {
      tasks.add(aTask);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTask(Task aTask)
  {
    boolean wasRemoved = false;
    //Unable to remove aTask, as it must always have a facade
    if (!this.equals(aTask.getFacade()))
    {
      tasks.remove(aTask);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTaskAt(Task aTask, int index)
  {  
    boolean wasAdded = false;
    if(addTask(aTask))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTasks()) { index = numberOfTasks() - 1; }
      tasks.remove(aTask);
      tasks.add(index, aTask);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTaskAt(Task aTask, int index)
  {
    boolean wasAdded = false;
    if(tasks.contains(aTask))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTasks()) { index = numberOfTasks() - 1; }
      tasks.remove(aTask);
      tasks.add(index, aTask);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTaskAt(aTask, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTools()
  {
    return 0;
  }

  public Tools addTool(String aName)
  {
    return new Tools(aName, this);
  }

  public boolean addTool(Tools aTool)
  {
    boolean wasAdded = false;
    if (tools.contains(aTool)) { return false; }
    Facade existingFacade = aTool.getFacade();
    boolean isNewFacade = existingFacade != null && !this.equals(existingFacade);
    if (isNewFacade)
    {
      aTool.setFacade(this);
    }
    else
    {
      tools.add(aTool);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTool(Tools aTool)
  {
    boolean wasRemoved = false;
    //Unable to remove aTool, as it must always have a facade
    if (!this.equals(aTool.getFacade()))
    {
      tools.remove(aTool);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addToolAt(Tools aTool, int index)
  {  
    boolean wasAdded = false;
    if(addTool(aTool))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTools()) { index = numberOfTools() - 1; }
      tools.remove(aTool);
      tools.add(index, aTool);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveToolAt(Tools aTool, int index)
  {
    boolean wasAdded = false;
    if(tools.contains(aTool))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTools()) { index = numberOfTools() - 1; }
      tools.remove(aTool);
      tools.add(index, aTool);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addToolAt(aTool, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfShoppingLists()
  {
    return 0;
  }

  public ShoppingList addShoppingList(String aName, String aLocation, int aIcon)
  {
    return new ShoppingList(aName, aLocation, aIcon, this);
  }

  public boolean addShoppingList(ShoppingList aShoppingList)
  {
    boolean wasAdded = false;
    if (shoppingLists.contains(aShoppingList)) { return false; }
    Facade existingFacade = aShoppingList.getFacade();
    boolean isNewFacade = existingFacade != null && !this.equals(existingFacade);
    if (isNewFacade)
    {
      aShoppingList.setFacade(this);
    }
    else
    {
      shoppingLists.add(aShoppingList);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeShoppingList(ShoppingList aShoppingList)
  {
    boolean wasRemoved = false;
    //Unable to remove aShoppingList, as it must always have a facade
    if (!this.equals(aShoppingList.getFacade()))
    {
      shoppingLists.remove(aShoppingList);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addShoppingListAt(ShoppingList aShoppingList, int index)
  {  
    boolean wasAdded = false;
    if(addShoppingList(aShoppingList))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShoppingLists()) { index = numberOfShoppingLists() - 1; }
      shoppingLists.remove(aShoppingList);
      shoppingLists.add(index, aShoppingList);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveShoppingListAt(ShoppingList aShoppingList, int index)
  {
    boolean wasAdded = false;
    if(shoppingLists.contains(aShoppingList))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShoppingLists()) { index = numberOfShoppingLists() - 1; }
      shoppingLists.remove(aShoppingList);
      shoppingLists.add(index, aShoppingList);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addShoppingListAt(aShoppingList, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=users.size(); i > 0; i--)
    {
      User aUser = users.get(i - 1);
      aUser.delete();
    }
    for(int i=tasks.size(); i > 0; i--)
    {
      Task aTask = tasks.get(i - 1);
      aTask.delete();
    }
    for(int i=tools.size(); i > 0; i--)
    {
      Tools aTool = tools.get(i - 1);
      aTool.delete();
    }
    for(int i=shoppingLists.size(); i > 0; i--)
    {
      ShoppingList aShoppingList = shoppingLists.get(i - 1);
      aShoppingList.delete();
    }
  }


  /**
   * Listeners
   */

  // line 110 "../../../class.ump"
  public void createListeners(){
    userRef.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				users.clear();

				for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
				    String name = (String) userSnapshot.child("name").getValue();

				    int points = 0;
				    int icon = R.drawable.ic_logo_mil;

                    String id = userSnapshot.getKey();

                    Home home = Facade.getInstance().getCurrentHome();

					User user = new User(name, home, Facade.getInstance());

					user.setIcon(icon);
					user.setPoints(points);
					user.setId(id);

					users.add(user);
				}
			}

			@Override
			public void onCancelled(DatabaseError error) {
					//don't worry this will definitely never fail (nope)
			}
		});

		shoppingRef.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				shoppingLists.clear();

				for (DataSnapshot shoppingListSnapshot : dataSnapshot.getChildren()) {
					ShoppingList list = shoppingListSnapshot.getValue(ShoppingList.class);
					shoppingLists.add(list);
				}
			}

			@Override
			public void onCancelled(DatabaseError error) {
					//don't worry this will probably never ever fail (never ever)
			}
		});

		taskRef.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				tasks.clear();

				for (DataSnapshot taskSnapshot : dataSnapshot.getChildren()) {
					Task task = taskSnapshot.getValue(Task.class);
					tasks.add(task);
				}
			}

			@Override
			public void onCancelled(DatabaseError error) {
					//don't worry this will never fail (not even once)
			}
		});
  }

  // line 177 "../../../class.ump"
  public void publishUsers(){
    for (User user : users) {
			DatabaseReference ref = this.getUserRef().child(user.getId());

			ref.child("name").setValue(user.getName());
			ref.child("icon").setValue(user.getIcon());
			ref.child("points").setValue(user.getPoints());

			DatabaseReference allocRef = ref.child("allocations");
			for (Allocation alloc : user.getAllocations()) {
				allocRef.child(alloc.getId()).setValue(alloc.getId());
			}



		}
  }

  // line 195 "../../../class.ump"
  public void publishTasks(){
    for (Task task : tasks) {
			this.getTaskRef().child(task.getId()).setValue(task);
		}
  }

  // line 201 "../../../class.ump"
  public void publishShoppingLists(){
    for (ShoppingList list : shoppingLists) {
			this.getShoppingRef().child(list.getId()).setValue(list);
		}
  }


  /**
   * END OF DATABASE ZONE//
   */
  // line 209 "../../../class.ump"
  public String getAllocationId(Allocation alloc){
    return alloc.getId();
  }

  // line 216 "../../../class.ump"
  public void createNewAccount(String name){
    currentHome.addUser(name, this);
  }

  // line 220 "../../../class.ump"
  public void allocateTask(User user, Task task){
    new Allocation(task, user);
  }

  // line 224 "../../../class.ump"
  public boolean markCompleted(Task task){
    if(currentUser == task.getUser())
			return task.markCompleted();  // Not sure how to respond if task is not InProgress
		return false;
  }

  // line 230 "../../../class.ump"
  public void addToShopping(ShoppingList list, String item){
    list.add(item);
  }


  /**
   * Figure out if you can deel with this (automatically using currentX)
   */
  
  // line 236 "../../../class.ump"
  public User addUser(String aName, int icon){
    User user = new User(aName, currentHome, this);
		user.setIcon(icon);
		return user;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "database" + "=" + (getDatabase() != null ? !getDatabase().equals(this)  ? getDatabase().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "userRef" + "=" + (getUserRef() != null ? !getUserRef().equals(this)  ? getUserRef().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "shoppingRef" + "=" + (getShoppingRef() != null ? !getShoppingRef().equals(this)  ? getShoppingRef().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "taskRef" + "=" + (getTaskRef() != null ? !getTaskRef().equals(this)  ? getTaskRef().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "currentHome" + "=" + (getCurrentHome() != null ? !getCurrentHome().equals(this)  ? getCurrentHome().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "currentUser" + "=" + (getCurrentUser() != null ? !getCurrentUser().equals(this)  ? getCurrentUser().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}