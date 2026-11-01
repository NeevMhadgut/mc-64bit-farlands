import java.util.List;
import java.util.Random;

public class ComponentVillageHouse3 extends ComponentVillage {
   private int a = -1;

   public ComponentVillageHouse3(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static ComponentVillageHouse3 findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, 0L, 0, 0L, 9L, 7, 12L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentVillageHouse3(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a < 0) {
         this.a = this.b(par1World, par3StructureBoundingBox);
         if (this.a < 0) {
            return true;
         }

         this.g.offset(0L, this.a - this.g.e + 7 - 1, 0L);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 1L, 7L, 4, 4L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 1, 6L, 8L, 4, 10L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 0, 5L, 8L, 0, 10L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 1L, 7L, 0, 4L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 0L, 3, 5L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 0, 0L, 8L, 3, 10L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 0L, 7L, 2, 0L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 5L, 2L, 1, 5L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 0, 6L, 2L, 3, 10L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 0, 10L, 7L, 3, 10L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 2, 0L, 7L, 3, 0L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 2, 5L, 2L, 3, 5L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 4, 1L, 8L, 4, 1L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 4, 4L, 3L, 4, 4L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 2L, 8L, 5, 3L, Block.x.bO, Block.x.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 0L, 4, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 0L, 4, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 8L, 4, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 8L, 4, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 8L, 4, 4L, par3StructureBoundingBox);
      int i = this.c(Block.at.bO, 3);
      int j = this.c(Block.at.bO, 2);

      for (int k = -1; k <= 2; k++) {
         for (int i1 = 0; i1 <= 8; i1++) {
            this.placeBlockAtCurrentPosition(par1World, Block.at.bO, i, i1, 4 + k, k, par3StructureBoundingBox);
            if ((k > -1 || i1 <= 1) && (k > 0 || i1 <= 3) && (k > 1 || i1 <= 4 || i1 >= 6)) {
               this.placeBlockAtCurrentPosition(par1World, Block.at.bO, j, i1, 4 + k, 5 - k, par3StructureBoundingBox);
            }
         }
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 4, 5L, 3L, 4, 10L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 4, 2L, 7L, 4, 10L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 5, 4L, 4L, 5, 10L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 5, 4L, 6L, 5, 10L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 6, 3L, 5L, 6, 10L, Block.x.bO, Block.x.bO, false);
      int l = this.c(Block.at.bO, 0);

      for (int j1 = 4; j1 >= 1; j1--) {
         this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, j1, 2 + j1, 7 - j1, par3StructureBoundingBox);

         for (int l1 = 8 - j1; l1 <= 10; l1++) {
            this.placeBlockAtCurrentPosition(par1World, Block.at.bO, l, j1, 2 + j1, l1, par3StructureBoundingBox);
         }
      }

      int k1 = this.c(Block.at.bO, 1);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 6L, 6, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 7L, 5, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.at.bO, k1, 6L, 6, 4L, par3StructureBoundingBox);

      for (int i2 = 6; i2 <= 8; i2++) {
         for (int l2 = 5; l2 <= 10; l2++) {
            this.placeBlockAtCurrentPosition(par1World, Block.at.bO, k1, i2, 12 - i2, l2, par3StructureBoundingBox);
         }
      }

      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 0L, 2, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 0L, 2, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 2, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 4L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 5L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 6L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 8L, 2, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 8L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 8L, 2, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 8L, 2, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 8L, 2, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 8L, 2, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 8L, 2, 7L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 8L, 2, 8L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 8L, 2, 9L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 2L, 2, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 2L, 2, 7L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 2L, 2, 8L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 2L, 2, 9L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 4L, 4, 10L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 5L, 4, 10L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 6L, 4, 10L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 5L, 5, 10L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 2L, 1, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 2L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 2L, 3, 1L, par3StructureBoundingBox);
      this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 2L, 1, 0L, this.c(Block.aE.bO, 1));
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, -1L, 3L, 2, -1L, 0, 0, false);
      if (this.getBlockIdAtCurrentPosition(par1World, 2L, 0, -1L, par3StructureBoundingBox) == 0
         && this.getBlockIdAtCurrentPosition(par1World, 2L, -1, -1L, par3StructureBoundingBox) != 0) {
         this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, this.c(Block.aH.bO, 3), 2L, 0, -1L, par3StructureBoundingBox);
      }

      for (int j2 = 0; j2 < 5; j2++) {
         for (int i3 = 0; i3 < 9; i3++) {
            this.clearCurrentPositionBlocksUpwards(par1World, i3, 7, j2, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.w.bO, 0, i3, -1, j2, par3StructureBoundingBox);
         }
      }

      for (int k2 = 5; k2 < 11; k2++) {
         for (int j3 = 2; j3 < 9; j3++) {
            this.clearCurrentPositionBlocksUpwards(par1World, j3, 7, k2, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.w.bO, 0, j3, -1, k2, par3StructureBoundingBox);
         }
      }

      this.spawnVillagers(par1World, par3StructureBoundingBox, 4L, 1, 2L, 2);
      return true;
   }
}
