import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeCorridor3 extends ComponentNetherBridgePiece {
   public ComponentNetherBridgeCorridor3(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.a((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 1, 0, true);
   }

   public static ComponentNetherBridgeCorridor3 createValidComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -7, 0L, 5L, 14, 10L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentNetherBridgeCorridor3(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      int i = this.c(Block.bC.bO, 2);

      for (int j = 0; j <= 9; j++) {
         int k = Math.max(1, 7 - j);
         int l = Math.min(Math.max(k + 5, 14 - j), 13);
         int i1 = j;
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, i1, 4L, k, i1, Block.bA.bO, Block.bA.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, k + 1, i1, 3L, l - 1, i1, 0, 0, false);
         if (j <= 6) {
            this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, i, 1L, k + 1, i1, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, i, 2L, k + 1, i1, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, i, 3L, k + 1, i1, par3StructureBoundingBox);
         }

         this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, l, i1, 4L, l, i1, Block.bA.bO, Block.bA.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, k + 1, i1, 0L, l - 1, i1, Block.bA.bO, Block.bA.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, k + 1, i1, 4L, l - 1, i1, Block.bA.bO, Block.bA.bO, false);
         if ((j & 1) == 0) {
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, k + 2, i1, 0L, k + 3, i1, Block.bB.bO, Block.bB.bO, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, k + 2, i1, 4L, k + 3, i1, Block.bB.bO, Block.bB.bO, false);
         }

         for (int j1 = 0; j1 <= 4; j1++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, j1, -1, i1, par3StructureBoundingBox);
         }
      }

      return true;
   }
}
