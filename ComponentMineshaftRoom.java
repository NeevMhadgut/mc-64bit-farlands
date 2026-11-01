import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ComponentMineshaftRoom extends StructureComponent {
   private LinkedList a = new LinkedList();

   public ComponentMineshaftRoom(int par1, Random par2Random, long par3, long par4) {
      super(par1);
      this.g = new StructureBoundingBox(par3, 50, par4, par3 + 7L + par2Random.nextInt(6), 54 + par2Random.nextInt(6), par4 + 7L + par2Random.nextInt(6));
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      int i = this.c();
      int j1 = this.g.c() - 3 - 1;
      if (j1 <= 0) {
         j1 = 1;
      }

      int j = 0;

      while (j < this.g.b()) {
         j += par3Random.nextInt(this.g.b());
         if (j + 3 > this.g.b()) {
            break;
         }

         StructureComponent structurecomponent = StructureMineshaftPieces.getNextComponent(
            par1StructureComponent, par2List, par3Random, this.g.a + j, this.g.b + par3Random.nextInt(j1) + 1, this.g.c - 1L, 2, i
         );
         if (structurecomponent != null) {
            StructureBoundingBox structureboundingbox = structurecomponent.b();
            this.a.add(new StructureBoundingBox(structureboundingbox.a, structureboundingbox.b, this.g.c, structureboundingbox.d, structureboundingbox.e, this.g.c + 1L));
         }

         j += 4;
      }

      j = 0;

      while (j < this.g.b()) {
         j += par3Random.nextInt(this.g.b());
         if (j + 3 > this.g.b()) {
            break;
         }

         StructureComponent structurecomponent1 = StructureMineshaftPieces.getNextComponent(
            par1StructureComponent, par2List, par3Random, this.g.a + j, this.g.b + par3Random.nextInt(j1) + 1, this.g.f + 1L, 0, i
         );
         if (structurecomponent1 != null) {
            StructureBoundingBox structureboundingbox1 = structurecomponent1.b();
            this.a.add(new StructureBoundingBox(structureboundingbox1.a, structureboundingbox1.b, this.g.f - 1L, structureboundingbox1.d, structureboundingbox1.e, this.g.f));
         }

         j += 4;
      }

      j = 0;

      while (j < this.g.d()) {
         j += par3Random.nextInt(this.g.d());
         if (j + 3 > this.g.d()) {
            break;
         }

         StructureComponent structurecomponent2 = StructureMineshaftPieces.getNextComponent(
            par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b + par3Random.nextInt(j1) + 1, this.g.c + j, 1, i
         );
         if (structurecomponent2 != null) {
            StructureBoundingBox structureboundingbox2 = structurecomponent2.b();
            this.a.add(new StructureBoundingBox(this.g.a, structureboundingbox2.b, structureboundingbox2.c, this.g.a + 1L, structureboundingbox2.e, structureboundingbox2.f));
         }

         j += 4;
      }

      j = 0;

      while (j < this.g.d()) {
         j += par3Random.nextInt(this.g.d());
         if (j + 3 > this.g.d()) {
            break;
         }

         StructureComponent structurecomponent3 = StructureMineshaftPieces.getNextComponent(
            par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b + par3Random.nextInt(j1) + 1, this.g.c + j, 3, i
         );
         if (structurecomponent3 != null) {
            StructureBoundingBox structureboundingbox3 = structurecomponent3.b();
            this.a.add(new StructureBoundingBox(this.g.d - 1L, structureboundingbox3.b, structureboundingbox3.c, this.g.d, structureboundingbox3.e, structureboundingbox3.f));
         }

         j += 4;
      }
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, this.g.a, this.g.b, this.g.c, this.g.d, this.g.b, this.g.f, Block.v.bO, 0, true);
      this.fillWithBlocks(
         par1World, par3StructureBoundingBox, this.g.a, this.g.b + 1, this.g.c, this.g.d, Math.min(this.g.b + 3, this.g.e), this.g.f, 0, 0, false
      );

      for (StructureBoundingBox structureboundingbox : this.a) {
         this.fillWithBlocks(
            par1World,
            par3StructureBoundingBox,
            structureboundingbox.a,
            structureboundingbox.e - 2,
            structureboundingbox.c,
            structureboundingbox.d,
            structureboundingbox.e,
            structureboundingbox.f,
            0,
            0,
            false
         );
      }

      this.randomlyRareFillWithBlocks(par1World, par3StructureBoundingBox, this.g.a, this.g.b + 4, this.g.c, this.g.d, this.g.e, this.g.f, 0, false);
      return true;
   }
}
