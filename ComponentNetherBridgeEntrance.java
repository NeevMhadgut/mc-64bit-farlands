import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeEntrance extends ComponentNetherBridgePiece {
   public ComponentNetherBridgeEntrance(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.a((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 5, 3, true);
   }

   public static ComponentNetherBridgeEntrance createValidComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -5L, -3, 0L, 13L, 14, 13L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentNetherBridgeEntrance(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 0L, 12L, 4, 12L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 0L, 12L, 13, 12L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 0L, 1L, 12, 12L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 11L, 5, 0L, 12L, 12, 12L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 5, 11L, 4L, 12, 12L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 5, 11L, 10L, 12, 12L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 9, 11L, 7L, 12, 12L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 5, 0L, 4L, 12, 1L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 5, 0L, 10L, 12, 1L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 9, 0L, 7L, 12, 1L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 11, 2L, 10L, 12, 10L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 8, 0L, 7L, 8, 0L, Block.bB.bO, Block.bB.bO, false);

      for (int i = 1; i <= 11; i += 2) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, i, 10, 0L, i, 11, 0L, Block.bB.bO, Block.bB.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, i, 10, 12L, i, 11, 12L, Block.bB.bO, Block.bB.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 10, i, 0L, 11, i, Block.bB.bO, Block.bB.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 12L, 10, i, 12L, 11, i, Block.bB.bO, Block.bB.bO, false);
         this.placeBlockAtCurrentPosition(par1World, Block.bA.bO, 0, i, 13, 0L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bA.bO, 0, i, 13, 12L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bA.bO, 0, 0L, 13, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bA.bO, 0, 12L, 13, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bB.bO, 0, i + 1, 13, 0L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bB.bO, 0, i + 1, 13, 12L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bB.bO, 0, 0L, 13, i + 1, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bB.bO, 0, 12L, 13, i + 1, par3StructureBoundingBox);
      }

      this.placeBlockAtCurrentPosition(par1World, Block.bB.bO, 0, 0L, 13, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bB.bO, 0, 0L, 13, 12L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bB.bO, 0, 0L, 13, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bB.bO, 0, 12L, 13, 0L, par3StructureBoundingBox);

      for (int j = 3; j <= 9; j += 2) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 7, j, 1L, 8, j, Block.bB.bO, Block.bB.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 11L, 7, j, 11L, 8, j, Block.bB.bO, Block.bB.bO, false);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 2, 0L, 8L, 2, 12L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 4L, 12L, 2, 8L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 0, 0L, 8L, 1, 3L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 0, 9L, 8L, 1, 12L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 4L, 3L, 1, 8L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 9L, 0, 4L, 12L, 1, 8L, Block.bA.bO, Block.bA.bO, false);

      for (int k = 4; k <= 8; k++) {
         for (int j1 = 0; j1 <= 2; j1++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, k, -1, j1, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, k, -1, 12 - j1, par3StructureBoundingBox);
         }
      }

      for (int l = 0; l <= 2; l++) {
         for (int k1 = 4; k1 <= 8; k1++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, l, -1, k1, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, 12 - l, -1, k1, par3StructureBoundingBox);
         }
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 5, 5L, 7L, 5, 7L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 1, 6L, 6L, 4, 6L, 0, 0, false);
      this.placeBlockAtCurrentPosition(par1World, Block.bA.bO, 0, 6L, 0, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.C.bO, 0, 6L, 5, 6L, par3StructureBoundingBox);
      long i1 = this.getXWithOffset(6L, 6L);
      int l1 = this.b(5);
      long i2 = this.getZWithOffset(6L, 6L);
      if (par3StructureBoundingBox.isVecInside(i1, l1, i2)) {
         par1World.a = true;
         Block.m[Block.C.bO].updateTick(par1World, i1, l1, i2, par2Random);
         par1World.a = false;
      }

      return true;
   }
}
