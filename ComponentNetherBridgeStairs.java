import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeStairs extends ComponentNetherBridgePiece {
   public ComponentNetherBridgeStairs(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.c((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 6, 2, false);
   }

   public static ComponentNetherBridgeStairs createValidComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -2L, 0, 0L, 7L, 11, 7L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentNetherBridgeStairs(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 6L, 1, 6L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 6L, 10, 6L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 1L, 8, 0L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 2, 0L, 6L, 8, 0L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 1L, 0L, 8, 6L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 2, 1L, 6L, 8, 6L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 2, 6L, 5L, 8, 6L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 2L, 0L, 5, 4L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 3, 2L, 6L, 5, 2L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 3, 4L, 6L, 5, 4L, Block.bB.bO, Block.bB.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.bA.bO, 0, 5L, 2, 5L, par3StructureBoundingBox);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 2, 5L, 4L, 3, 5L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 2, 5L, 3L, 4, 5L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 2, 5L, 2L, 5, 5L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 2, 5L, 1L, 6, 5L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 7, 1L, 5L, 7, 4L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 8, 2L, 6L, 8, 4L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 6, 0L, 4L, 8, 0L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 5, 0L, 4L, 5, 0L, Block.bB.bO, Block.bB.bO, false);

      for (int i = 0; i <= 6; i++) {
         for (int j = 0; j <= 6; j++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, i, -1, j, par3StructureBoundingBox);
         }
      }

      return true;
   }
}
