import java.util.ArrayList;
import java.util.Random;

class StructureStrongholdStart extends StructureStart {
   public StructureStrongholdStart(World par1World, Random par2Random, long par3, long par4) {
      StructureStrongholdPieces.a();
      s componentstrongholdstairs2 = new s(0, par2Random, (par3 << 4) + 2L, (par4 << 4) + 2L);
      this.a.add(componentstrongholdstairs2);
      componentstrongholdstairs2.a(componentstrongholdstairs2, this.a, par2Random);
      ArrayList arraylist = componentstrongholdstairs2.c;

      while (!arraylist.isEmpty()) {
         int i = par2Random.nextInt(arraylist.size());
         StructureComponent structurecomponent = (StructureComponent)arraylist.remove(i);
         structurecomponent.a(componentstrongholdstairs2, this.a, par2Random);
      }

      this.c();
      this.a(par1World, par2Random, 10);
   }
}
