import java.util.List;
import java.util.Random;

public class ComponentVillageChurch extends ComponentVillage {
   private int a = -1;

   public ComponentVillageChurch(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static ComponentVillageChurch findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, 0L, 0, 0L, 5L, 12, 9L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentVillageChurch(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a < 0) {
         this.a = this.b(par1World, par3StructureBoundingBox);
         if (this.a < 0) {
            return true;
         }

         this.g.offset(0L, this.a - this.g.e + 12 - 1, 0L);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 1L, 3L, 3, 7L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 5, 1L, 3L, 9, 3L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 0L, 3L, 0, 8L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 0L, 3L, 10, 0L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 1L, 0L, 10, 3L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 1, 1L, 4L, 10, 3L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 4L, 0L, 4, 7L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 0, 4L, 4L, 4, 7L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 8L, 3L, 4, 8L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 5, 4L, 3L, 10, 4L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 5, 5L, 3L, 5, 7L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 9, 0L, 4L, 9, 4L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 4, 0L, 4L, 4, 4L, Block.w.bO, Block.w.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 0L, 11, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 4L, 11, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 2L, 11, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 2L, 11, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 1L, 1, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 1L, 1, 7L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 2L, 1, 7L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 3L, 1, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 3L, 1, 7L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, this.c(Block.aH.bO, 3), 1L, 1, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, this.c(Block.aH.bO, 3), 2L, 1, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, this.c(Block.aH.bO, 3), 3L, 1, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, this.c(Block.aH.bO, 1), 1L, 2, 7L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, this.c(Block.aH.bO, 0), 3L, 2, 7L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 3, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 4L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 4L, 3, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 6, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 7, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 4L, 6, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 4L, 7, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 2L, 6, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 2L, 7, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 2L, 6, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 2L, 7, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 3, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 4L, 3, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 2L, 3, 8L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 2L, 4, 7L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 1L, 4, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 3L, 4, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 2L, 4, 5L, par3StructureBoundingBox);
      int i = this.c(Block.aF.bO, 4);

      for (int j = 1; j <= 9; j++) {
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, i, 3L, j, 3L, par3StructureBoundingBox);
      }

      this.placeBlockAtCurrentPosition(par1World, 0, 0, 2L, 1, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 2L, 2, 0L, par3StructureBoundingBox);
      this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 2L, 1, 0L, this.c(Block.aE.bO, 1));
      if (this.getBlockIdAtCurrentPosition(par1World, 2L, 0, -1L, par3StructureBoundingBox) == 0
         && this.getBlockIdAtCurrentPosition(par1World, 2L, -1, -1L, par3StructureBoundingBox) != 0) {
         this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, this.c(Block.aH.bO, 3), 2L, 0, -1L, par3StructureBoundingBox);
      }

      for (int k = 0; k < 9; k++) {
         for (int l = 0; l < 5; l++) {
            this.clearCurrentPositionBlocksUpwards(par1World, l, 12, k, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.w.bO, 0, l, -1, k, par3StructureBoundingBox);
         }
      }

      this.spawnVillagers(par1World, par3StructureBoundingBox, 2L, 1, 2L, 1);
      return true;
   }

   @Override
   protected int a(int par1) {
      return 2;
   }
}
