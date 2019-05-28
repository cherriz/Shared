using System;

namespace Assignment1
{
    /* Base Class: 
        MobileObject
        Name
        ID
        Position (x,y,z)  - is generated randomly as an x, y, z
        PositionCell this is the specific cell ID it is located on.  
        All mobile objects have a method move(dx, dy,dz) which will change their position, and calculate a new cell 
        location by changing their position by + dx, +dy + dz (which can be negative values)
        ID should be unique, but it should be assigned to the object when it is created, your main program should have a 
        list of Mobile Objects, and the ID’s should be created in sequence.  Names can be random or hard coded, and positions should be random.  
        */
    public abstract class MobileObject
    {
        public int PositionCell { get; set; }

        public Position Position { get; set; }

        public string Name { get; set; }

        public int ID { get; set; }

        public MobileObject(string name, int id)
        {
            this.Name = name;
            this.ID = id;
            Random random = new Random();
            this.Position = new Position(random.Next(), random.Next(), random.Next());
        }

        public void Move(int dx, int dy, int dz)
        {
            this.Position.x += dx;
            this.Position.y += dy;
            this.Position.z += dz;
        }
    }
}
