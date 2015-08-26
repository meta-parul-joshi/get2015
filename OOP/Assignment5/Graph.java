
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph  implements Node {

	List<Entity> nodeList = new ArrayList<Entity>();
	HashMap entityFriendship = new HashMap();
	
	public List<Entity> addNode ( Entity entity ) 
	{
		nodeList.add(entity);
		return nodeList;
	}
	
	boolean deleteNode ( List<Entity> nodeList, String entityName, HashMap entityFriendship ) 
	{		
		boolean flag = false;
		for(Entity entity : new ArrayList<Entity> (nodeList))
		{
			if (entity.name.equals(entityName))
			{	
				nodeList.remove(entity);
				Set set = entityFriendship.entrySet();
				Iterator iterator = set.iterator();
				while ( iterator.hasNext() )
				{
					Map.Entry me = (Map.Entry)iterator.next();
					if ( me.getKey().equals(entityName))
					{
						iterator.remove();
					}
					else if(me.getValue().toString().contains(entityName))
					{
						me.setValue(me.getValue().toString().replaceAll(" "+entityName,""));
					}
				}
				flag = true;
			}
		}
		return flag;
	} 
	
	void printNodeSet( List<Entity> nodeList )
	{
		
		for(Entity entity : nodeList)
		{
			System.out.println(entity.name);
		}
	}
	
}
