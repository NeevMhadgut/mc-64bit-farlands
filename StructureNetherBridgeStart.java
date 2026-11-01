import java.util.ArrayList;
import java.util.Random;

class StructureNetherBridgeStart extends StructureStart {
   public StructureNetherBridgeStart(World par1World, Random par2Random, long par3, long par4) {
      ComponentNetherBridgeStartPiece componentnetherbridgestartpiece = new ComponentNetherBridgeStartPiece(par2Random, (par3 << 4) + 2L, (par4 << 4) + 2L);
      this.a.add(componentnetherbridgestartpiece);
      componentnetherbridgestartpiece.a(componentnetherbridgestartpiece, this.a, par2Random);
      ArrayList arraylist = componentnetherbridgestartpiece.d;

      while (!arraylist.isEmpty()) {
         int i = par2Random.nextInt(arraylist.size());
         StructureComponent structurecomponent = (StructureComponent)arraylist.remove(i);
         structurecomponent.a(componentnetherbridgestartpiece, this.a, par2Random);
      }

      this.c();
      this.a(par1World, par2Random, 48, 70);
   }
}
