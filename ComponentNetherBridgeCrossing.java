import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeCrossing extends ComponentNetherBridgePiece {
   public ComponentNetherBridgeCrossing(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.a((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 2, 0, false);
      this.b((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 0, 2, false);
      this.c((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 0, 2, false);
   }

   public static ComponentNetherBridgeCrossing createValidComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -2L, 0, 0L, 7L, 9, 7L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentNetherBridgeCrossing(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 6L, 1, 6L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 6L, 7, 6L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 1L, 6, 0L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 6L, 1L, 6, 6L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 2, 0L, 6L, 6, 0L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 2, 6L, 6L, 6, 6L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 0L, 6, 1L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 5L, 0L, 6, 6L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 2, 0L, 6L, 6, 1L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 2, 5L, 6L, 6, 6L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 6, 0L, 4L, 6, 0L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 5, 0L, 4L, 5, 0L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 6, 6L, 4L, 6, 6L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 5, 6L, 4L, 5, 6L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 6, 2L, 0L, 6, 4L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 2L, 0L, 5, 4L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 6, 2L, 6L, 6, 4L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 5, 2L, 6L, 5, 4L, Block.bB.bO, Block.bB.bO, false);

      for (int i = 0; i <= 6; i++) {
         for (int j = 0; j <= 6; j++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, i, -1, j, par3StructureBoundingBox);
         }
      }

      return true;
   }
}
