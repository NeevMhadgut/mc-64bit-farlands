import java.util.List;
import java.util.Random;

public class ComponentVillageWell extends ComponentVillage {
   private final boolean a = true;
   private int b = -1;

   public ComponentVillageWell(int par1, Random par2Random, long par3, long par4) {
      super(par1);
      this.h = par2Random.nextInt(4);
      switch (this.h) {
         case 0:
         case 2:
            this.g = new StructureBoundingBox(par3, 64, par4, par3 + 6L - 1L, 78, par4 + 6L - 1L);
            break;
         default:
            this.g = new StructureBoundingBox(par3, 64, par4, par3 + 6L - 1L, 78, par4 + 6L - 1L);
      }
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.e - 4, this.g.c + 1L, 1, this.c());
      StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.e - 4, this.g.c + 1L, 3, this.c());
      StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.a + 1L, this.g.e - 4, this.g.c - 1L, 2, this.c());
      StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.a + 1L, this.g.e - 4, this.g.f + 1L, 0, this.c());
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.b < 0) {
         this.b = this.b(par1World, par3StructureBoundingBox);
         if (this.b < 0) {
            return true;
         }

         this.g.offset(0L, this.b - this.g.e + 3, 0L);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 1L, 4L, 12, 4L, Block.w.bO, Block.A.bO, false);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 2L, 12, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 3L, 12, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 2L, 12, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 3L, 12, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 1L, 13, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 1L, 14, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 4L, 13, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 4L, 14, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 1L, 13, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 1L, 14, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 4L, 13, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 4L, 14, 4L, par3StructureBoundingBox);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 15, 1L, 4L, 15, 4L, Block.w.bO, Block.w.bO, false);

      for (int i = 0; i <= 5; i++) {
         for (int j = 0; j <= 5; j++) {
            if (j == 0 || j == 5 || i == 0 || i == 5) {
               this.placeBlockAtCurrentPosition(par1World, Block.F.bO, 0, j, 11, i, par3StructureBoundingBox);
               this.clearCurrentPositionBlocksUpwards(par1World, j, 12, i, par3StructureBoundingBox);
            }
         }
      }

      return true;
   }
}
