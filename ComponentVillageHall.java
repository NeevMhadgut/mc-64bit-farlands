import java.util.List;
import java.util.Random;

public class ComponentVillageHall extends ComponentVillage {
   private int a = -1;

   public ComponentVillageHall (int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static p findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, 0L, 0, 0L, 9L, 7, 11L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentVillageHall (par6, par1Random, structureboundingbox, par5) : null;
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
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 0, 6L, 8L, 0, 10L, Block.v.bO, Block.v.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 6L, 0, 6L, par3StructureBoundingBox);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 1, 6L, 2L, 1, 10L, Block.aZ.bO, Block.aZ.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 1, 6L, 8L, 1, 10L, Block.aZ.bO, Block.aZ.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 1, 10L, 7L, 1, 10L, Block.aZ.bO, Block.aZ.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 1L, 7L, 0, 4L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 0L, 3, 5L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 0, 0L, 8L, 3, 5L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 0L, 7L, 1, 0L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 5L, 7L, 1, 5L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 2, 0L, 7L, 3, 0L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 2, 5L, 7L, 3, 5L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 4, 1L, 8L, 4, 1L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 4, 4L, 8L, 4, 4L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 2L, 8L, 5, 3L, Block.x.bO, Block.x.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 0L, 4, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 0L, 4, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 8L, 4, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 8L, 4, 3L, par3StructureBoundingBox);
      int i = this.c(Block.at.bO, 3);
      int j = this.c(Block.at.bO, 2);

      for (int k = -1; k <= 2; k++) {
         for (int i1 = 0; i1 <= 8; i1++) {
            this.placeBlockAtCurrentPosition(par1World, Block.at.bO, i, i1, 4 + k, k, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.at.bO, j, i1, 4 + k, 5 - k, par3StructureBoundingBox);
         }
      }

      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 0L, 2, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 0L, 2, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 8L, 2, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.J.bO, 0, 8L, 2, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 2, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 8L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 8L, 2, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 2L, 2, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 3L, 2, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 5L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 6L, 2, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 2L, 1, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aM.bO, 0, 2L, 2, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 1L, 1, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.at.bO, this.c(Block.at.bO, 3), 2L, 1, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.at.bO, this.c(Block.at.bO, 1), 1L, 1, 3L, par3StructureBoundingBox);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 0, 1L, 7L, 0, 3L, Block.aj.bO, Block.aj.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.aj.bO, 0, 6L, 1, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aj.bO, 0, 6L, 1, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 2L, 1, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 2L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 2L, 3, 1L, par3StructureBoundingBox);
      this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 2L, 1, 0L, this.c(Block.aE.bO, 1));
      if (this.getBlockIdAtCurrentPosition(par1World, 2L, 0, -1L, par3StructureBoundingBox) == 0
         && this.getBlockIdAtCurrentPosition(par1World, 2L, -1, -1L, par3StructureBoundingBox) != 0) {
         this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, this.c(Block.aH.bO, 3), 2L, 0, -1L, par3StructureBoundingBox);
      }

      this.placeBlockAtCurrentPosition(par1World, 0, 0, 6L, 1, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 6L, 2, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 6L, 3, 4L, par3StructureBoundingBox);
      this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 6L, 1, 5L, this.c(Block.aE.bO, 1));

      for (int l = 0; l < 5; l++) {
         for (int j1 = 0; j1 < 9; j1++) {
            this.clearCurrentPositionBlocksUpwards(par1World, j1, 7, l, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.w.bO, 0, j1, -1, l, par3StructureBoundingBox);
         }
      }

      this.spawnVillagers(par1World, par3StructureBoundingBox, 4L, 1, 2L, 2);
      return true;
   }

   @Override
   protected int a(int par1) {
      return par1 != 0 ? 0 : 4;
   }
}
