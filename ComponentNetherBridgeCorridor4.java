import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeCorridor4 extends ComponentNetherBridgePiece {
   public ComponentNetherBridgeCorridor4(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      byte byte0 = 1;
      if (this.h == 1 || this.h == 2) {
         byte0 = 5;
      }

      this.b((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 0, byte0, par3Random.nextInt(8) > 0);
      this.c((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 0, byte0, par3Random.nextInt(8) > 0);
   }

   public static ComponentNetherBridgeCorridor4 createValidComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -3L, 0, 0L, 9L, 7, 9L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentNetherBridgeCorridor4(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 8L, 1, 8L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 8L, 5, 8L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 6, 0L, 8L, 6, 5L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 2L, 5, 0L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 2, 0L, 8L, 5, 0L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 3, 0L, 1L, 4, 0L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 3, 0L, 7L, 4, 0L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 4L, 8L, 2, 8L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 4L, 2L, 2, 4L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 1, 4L, 7L, 2, 4L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 8L, 8L, 3, 8L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 6L, 0L, 3, 7L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 3, 6L, 8L, 3, 7L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 4L, 0L, 5, 5L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 3, 4L, 8L, 5, 5L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 3, 5L, 2L, 5, 5L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 3, 5L, 7L, 5, 5L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 4, 5L, 1L, 5, 5L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 4, 5L, 7L, 5, 5L, Block.bB.bO, Block.bB.bO, false);

      for (int i = 0; i <= 5; i++) {
         for (int j = 0; j <= 8; j++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, j, -1, i, par3StructureBoundingBox);
         }
      }

      return true;
   }
}
