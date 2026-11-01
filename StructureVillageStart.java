import java.util.ArrayList;
import java.util.Random;

class StructureVillageStart extends StructureStart {
   private boolean c = false;

   public StructureVillageStart(World par1World, Random par2Random, long par3, long par4, int par5) {
      int i = par5;
      ArrayList arraylist = StructureVillagePieces.a(par2Random, i);
      g componentvillagestartpiece = new g(par1World.i(), 0, par2Random, (par3 << 4) + 2L, (par4 << 4) + 2L, arraylist, i);
      this.a.add(componentvillagestartpiece);
      componentvillagestartpiece.a(componentvillagestartpiece, this.a, par2Random);
      ArrayList arraylist1 = componentvillagestartpiece.f;
      ArrayList arraylist2 = componentvillagestartpiece.e;

      while (!arraylist1.isEmpty() || !arraylist2.isEmpty()) {
         if (!arraylist1.isEmpty()) {
            int j = par2Random.nextInt(arraylist1.size());
            StructureComponent structurecomponent = (StructureComponent)arraylist1.remove(j);
            structurecomponent.a(componentvillagestartpiece, this.a, par2Random);
         } else {
            int k = par2Random.nextInt(arraylist2.size());
            StructureComponent structurecomponent1 = (StructureComponent)arraylist2.remove(k);
            structurecomponent1.a(componentvillagestartpiece, this.a, par2Random);
         }
      }

      this.c();
      int l = 0;

      for (StructureComponent structurecomponent2 : this.a) {
         if (!(structurecomponent2 instanceof cf)) {
            l++;
         }
      }

      this.c = l > 2;
   }

   @Override
   public boolean d() {
      return this.c;
   }
}
