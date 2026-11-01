import java.util.List;
import java.util.Random;

public class ComponentVillageHouse4_Garden extends ComponentVillage {
   private int a = -1;
   private final boolean b;

   public ComponentVillageHouse4_Garden(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
      this.b = par2Random.nextBoolean();
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static ComponentVillageHouse4_Garden findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, 0L, 0, 0L, 5L, 6, 5L, par5);
      return StructureComponent.a(par0List, structureboundingbox) != null ? null : new ComponentVillageHouse4_Garden(par6, par1Random, structureboundingbox, par5);
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a < 0) {
         this.a = this.b(par1World, par3StructureBoundingBox);
         if (this.a < 0) {
            return true;
         }

         this.g.offset(0L, this.a - this.g.e + 6 - 1, 0L);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 4L, 0, 4L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 4, 0L, 4L, 4, 4L, Block.J.bO, Block.J.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 4, 1L, 3L, 4, 3L, Block.x.bO, Block.x.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 0L, 1, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 0L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 0L, 3, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 4L, 1, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 4L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 4L, 3, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 0L, 1, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 0L, 2, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 0L, 3, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 4L, 1, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 4L, 2, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 4L, 3, 4L, par3StructureBoundingBox);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 1L, 0L, 3, 3L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 1, 1L, 4L, 3, 3L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 4L, 3L, 3, 4L, Block.x.bO, Block.x.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 2L, 2, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 4L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 1L, 1, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 1L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 1L, 3, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 2L, 3, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 3L, 3, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 3L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 3L, 1, 0L, par3StructureBoundingBox);
      if (this.getBlockIdAtCurrentPosition(par1World, 2L, 0, -1L, par3StructureBoundingBox) == 0
         && this.getBlockIdAtCurrentPosition(par1World, 2L, -1, -1L, par3StructureBoundingBox) != 0) {
         this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, this.c(Block.aH.bO, 3), 2L, 0, -1L, par3StructureBoundingBox);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 1L, 3L, 3, 3L, 0, 0, false);
      if (this.b) {
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 0L, 5, 0L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 1L, 5, 0L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 2L, 5, 0L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 3L, 5, 0L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 4L, 5, 0L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 0L, 5, 4L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 1L, 5, 4L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 2L, 5, 4L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 3L, 5, 4L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 4L, 5, 4L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 4L, 5, 1L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 4L, 5, 2L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 4L, 5, 3L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 0L, 5, 1L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 0L, 5, 2L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 0L, 5, 3L, par3StructureBoundingBox);
      }

      if (this.b) {
         int i = this.c(Block.aF.bO, 3);
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, i, 3L, 1, 3L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, i, 3L, 2, 3L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, i, 3L, 3, 3L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, i, 3L, 4, 3L, par3StructureBoundingBox);
      }

      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 2L, 3, 1L, par3StructureBoundingBox);

      for (int j = 0; j < 5; j++) {
         for (int k = 0; k < 5; k++) {
            this.clearCurrentPositionBlocksUpwards(par1World, k, 6, j, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.w.bO, 0, k, -1, j, par3StructureBoundingBox);
         }
      }

      this.spawnVillagers(par1World, par3StructureBoundingBox, 1L, 1, 2L, 1);
      return true;
   }
}
