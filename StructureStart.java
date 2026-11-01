import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public abstract class StructureStart {
   protected LinkedList a = new LinkedList();
   protected StructureBoundingBox b;

   protected StructureStart() {
   }

   public StructureBoundingBox a() {
      return this.b;
   }

   public LinkedList b() {
      return this.a;
   }

   public void a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      Iterator iterator = this.a.iterator();

      while (iterator.hasNext()) {
         StructureComponent structurecomponent = (StructureComponent)iterator.next();
         if (structurecomponent.b().a(par3StructureBoundingBox) && !structurecomponent.a(par1World, par2Random, par3StructureBoundingBox)) {
            iterator.remove();
         }
      }
   }

   protected void c() {
      this.b = StructureBoundingBox.a();

      for (StructureComponent structurecomponent : this.a) {
         this.b.b(structurecomponent.b());
      }
   }

   protected void a(World par1World, Random par2Random, int par3) {
      int i = 63 - par3;
      int j = this.b.c() + 1;
      if (j < i) {
         j += par2Random.nextInt(i - j);
      }

      int k = j - this.b.e;
      this.b.offset(0L, k, 0L);

      for (StructureComponent structurecomponent : this.a) {
         structurecomponent.b().offset(0L, k, 0L);
      }
   }

   protected void a(World par1World, Random par2Random, int par3, int par4) {
      int i = par4 - par3 + 1 - this.b.c();
      int j = 1;
      if (i > 1) {
         j = par3 + par2Random.nextInt(i);
      } else {
         j = par3;
      }

      int k = j - this.b.b;
      this.b.offset(0L, k, 0L);

      for (StructureComponent structurecomponent : this.a) {
         structurecomponent.b().offset(0L, k, 0L);
      }
   }

   public boolean d() {
      return true;
   }
}
