import java.util.List;
import java.util.Random;

public class ComponentMineshaftCross extends StructureComponent {
   private final int a;
   private final boolean b;

   public ComponentMineshaftCross(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.a = par4;
      this.g = par3StructureBoundingBox;
      this.b = par3StructureBoundingBox.c() > 3;
   }

   public static StructureBoundingBox findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5) {
      StructureBoundingBox structureboundingbox = new StructureBoundingBox(par2, par3, par4, par2, par3 + 2, par4);
      if (par1Random.nextInt(4) == 0) {
         structureboundingbox.e += 4;
      }

      switch (par5) {
         case 0:
            structureboundingbox.a = par2 - 1L;
            structureboundingbox.d = par2 + 3L;
            structureboundingbox.f = par4 + 4L;
            break;
         case 1:
            structureboundingbox.a = par2 - 4L;
            structureboundingbox.c = par4 - 1L;
            structureboundingbox.f = par4 + 3L;
            break;
         case 2:
            structureboundingbox.a = par2 - 1L;
            structureboundingbox.d = par2 + 3L;
            structureboundingbox.c = par4 - 4L;
            break;
         case 3:
            structureboundingbox.d = par2 + 4L;
            structureboundingbox.c = par4 - 1L;
            structureboundingbox.f = par4 + 3L;
      }

      return StructureComponent.a(par0List, structureboundingbox) != null ? null : structureboundingbox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      int i = this.c();
      switch (this.a) {
         case 0:
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a + 1L, this.g.b, this.g.f + 1L, 0, i);
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b, this.g.c + 1L, 1, i);
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b, this.g.c + 1L, 3, i);
            break;
         case 1:
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a + 1L, this.g.b, this.g.c - 1L, 2, i);
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a + 1L, this.g.b, this.g.f + 1L, 0, i);
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b, this.g.c + 1L, 1, i);
            break;
         case 2:
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a + 1L, this.g.b, this.g.c - 1L, 2, i);
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b, this.g.c + 1L, 1, i);
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b, this.g.c + 1L, 3, i);
            break;
         case 3:
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a + 1L, this.g.b, this.g.c - 1L, 2, i);
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a + 1L, this.g.b, this.g.f + 1L, 0, i);
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b, this.g.c + 1L, 3, i);
      }

      if (this.b) {
         if (par3Random.nextBoolean()) {
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a + 1L, this.g.b + 3 + 1, this.g.c - 1L, 2, i);
         }

         if (par3Random.nextBoolean()) {
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b + 3 + 1, this.g.c + 1L, 1, i);
         }

         if (par3Random.nextBoolean()) {
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b + 3 + 1, this.g.c + 1L, 3, i);
         }

         if (par3Random.nextBoolean()) {
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a + 1L, this.g.b + 3 + 1, this.g.f + 1L, 0, i);
         }
      }
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      if (this.b) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, this.g.a + 1L, this.g.b, this.g.c, this.g.d - 1L, this.g.b + 3 - 1, this.g.f, 0, 0, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, this.g.a, this.g.b, this.g.c + 1L, this.g.d, this.g.b + 3 - 1, this.g.f - 1L, 0, 0, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, this.g.a + 1L, this.g.e - 2, this.g.c, this.g.d - 1L, this.g.e, this.g.f, 0, 0, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, this.g.a, this.g.e - 2, this.g.c + 1L, this.g.d, this.g.e, this.g.f - 1L, 0, 0, false);
         this.fillWithBlocks(
            par1World, par3StructureBoundingBox, this.g.a + 1L, this.g.b + 3, this.g.c + 1L, this.g.d - 1L, this.g.b + 3, this.g.f - 1L, 0, 0, false
         );
      } else {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, this.g.a + 1L, this.g.b, this.g.c, this.g.d - 1L, this.g.e, this.g.f, 0, 0, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, this.g.a, this.g.b, this.g.c + 1L, this.g.d, this.g.e, this.g.f - 1L, 0, 0, false);
      }

      this.fillWithBlocks(
         par1World, par3StructureBoundingBox, this.g.a + 1L, this.g.b, this.g.c + 1L, this.g.a + 1L, this.g.e, this.g.c + 1L, Block.x.bO, 0, false
      );
      this.fillWithBlocks(
         par1World, par3StructureBoundingBox, this.g.a + 1L, this.g.b, this.g.f - 1L, this.g.a + 1L, this.g.e, this.g.f - 1L, Block.x.bO, 0, false
      );
      this.fillWithBlocks(
         par1World, par3StructureBoundingBox, this.g.d - 1L, this.g.b, this.g.c + 1L, this.g.d - 1L, this.g.e, this.g.c + 1L, Block.x.bO, 0, false
      );
      this.fillWithBlocks(
         par1World, par3StructureBoundingBox, this.g.d - 1L, this.g.b, this.g.f - 1L, this.g.d - 1L, this.g.e, this.g.f - 1L, Block.x.bO, 0, false
      );

      for (long i = this.g.a; i <= this.g.d; i++) {
         for (long j = this.g.c; j <= this.g.f; j++) {
            int k = this.getBlockIdAtCurrentPosition(par1World, i, this.g.b - 1, j, par3StructureBoundingBox);
            if (k == 0) {
               this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, i, this.g.b - 1, j, par3StructureBoundingBox);
            }
         }
      }

      return true;
   }
}
