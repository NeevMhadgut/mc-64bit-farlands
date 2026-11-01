import java.util.List;
import java.util.Random;

public class ComponentVillageHouse1 extends ComponentVillage {
   private int a = -1;

   public ComponentVillageHouse1(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static ComponentVillageHouse1 findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, 0L, 0, 0L, 9L, 9, 6L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentVillageHouse1(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a < 0) {
         this.a = this.b(par1World, par3StructureBoundingBox);
         if (this.a < 0) {
            return true;
         }

         this.g.offset(0L, this.a - this.g.e + 9 - 1, 0L);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 1L, 7L, 5, 4L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 8L, 0, 5L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 0L, 8L, 5, 5L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 6, 1L, 8L, 6, 4L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 7, 2L, 8L, 7, 3L, Block.w.bO, Block.w.bO, false);
      int i = this.c(Block.at.bO, 3);
      int j = this.c(Block.at.bO, 2);

      for (int k = -1; k <= 2; k++) {
         for (int i1 = 0; i1 <= 8; i1++) {
            this.placeBlockAtCurrentPosition(par1World, Block.at.bO, i, i1, 6 + k, k, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.at.bO, j, i1, 6 + k, 5 - k, par3StructureBoundingBox);
         }
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 0L, 0L, 1, 5L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 5L, 8L, 1, 5L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 1, 0L, 8L, 1, 4L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 1, 0L, 7L, 1, 0L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 0L, 4, 0L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 5L, 0L, 4, 5L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 2, 5L, 8L, 4, 5L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 2, 0L, 8L, 4, 0L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 1L, 0L, 4, 4L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 2, 5L, 7L, 4, 5L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 2, 1L, 8L, 4, 4L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 2, 0L, 7L, 4, 0L, Block.x.bO, Block.x.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 4L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 5L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 6L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 4L, 3, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 5L, 3, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 6L, 3, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 2, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 3, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 3, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 8L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 8L, 2, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 8L, 3, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 8L, 3, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 2L, 2, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 3L, 2, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 5L, 2, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 6L, 2, 5L, par3StructureBoundingBox);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 4, 1L, 7L, 4, 1L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 4, 4L, 7L, 4, 4L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 3, 4L, 7L, 3, 4L, Block.MapGenVillage.bO, Block.MapGenVillage.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 7L, 1, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.at.bO, this.c(Block.at.bO, 0), 7L, 1, 3L, par3StructureBoundingBox);
      int l = this.c(Block.at.bO, 3);
      this.placeBlockAtCurrentPosition(par1World, Block.at.bO, l, 6L, 1, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.at.bO, l, 5L, 1, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.at.bO, l, 4L, 1, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.at.bO, l, 3L, 1, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 6L, 1, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aM.bO, 0, 6L, 2, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 4L, 1, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aM.bO, 0, 4L, 2, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.StructureNetherBridgeStart.bO, 0, 7L, 1, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 1L, 1, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, 0, 0, 1L, 2, 0L, par3StructureBoundingBox);
      this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 1L, 1, 0L, this.c(Block.aE.bO, 1));
      if (this.getBlockIdAtCurrentPosition(par1World, 1L, 0, -1L, par3StructureBoundingBox) == 0
         && this.getBlockIdAtCurrentPosition(par1World, 1L, -1, -1L, par3StructureBoundingBox) != 0) {
         this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, this.c(Block.aH.bO, 3), 1L, 0, -1L, par3StructureBoundingBox);
      }

      for (int j1 = 0; j1 < 6; j1++) {
         for (int k1 = 0; k1 < 9; k1++) {
            this.clearCurrentPositionBlocksUpwards(par1World, k1, 9, j1, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.w.bO, 0, k1, -1, j1, par3StructureBoundingBox);
         }
      }

      this.spawnVillagers(par1World, par3StructureBoundingBox, 2L, 1, 2L, 1);
      return true;
   }

   @Override
   protected int a(int par1) {
      return 1;
   }
}
