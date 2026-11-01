import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeNetherStalkRoom extends ComponentNetherBridgePiece {
   public ComponentNetherBridgeNetherStalkRoom(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.a((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 5, 3, true);
      this.a((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 5, 11, true);
   }

   public static ComponentNetherBridgeNetherStalkRoom createValidComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -5L, -3, 0L, 13L, 14, 13L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentNetherBridgeNetherStalkRoom(par6, par1Random, structureboundingbox, par5) : null;
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

      int k = this.c(Block.bC.bO, 3);

      for (int l = 0; l <= 6; l++) {
         int k1 = l + 4;

         for (int i2 = 5; i2 <= 7; i2++) {
            this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, k, i2, 5 + l, k1, par3StructureBoundingBox);
         }

         if (k1 >= 5 && k1 <= 8) {
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 5, k1, 7L, l + 4, k1, Block.bA.bO, Block.bA.bO, false);
         } else if (k1 >= 9 && k1 <= 10) {
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 8, k1, 7L, l + 4, k1, Block.bA.bO, Block.bA.bO, false);
         }

         if (l >= 1) {
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 6 + l, k1, 7L, 9 + l, k1, 0, 0, false);
         }
      }

      for (int i1 = 5; i1 <= 7; i1++) {
         this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, k, i1, 12, 11L, par3StructureBoundingBox);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 6, 7L, 5L, 7, 7L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 6, 7L, 7L, 7, 7L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 13, 12L, 7L, 13, 12L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 5, 2L, 3L, 5, 3L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 5, 9L, 3L, 5, 10L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 5, 4L, 2L, 5, 8L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 9L, 5, 2L, 10L, 5, 3L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 9L, 5, 9L, 10L, 5, 10L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 10L, 5, 4L, 10L, 5, 8L, Block.bA.bO, Block.bA.bO, false);
      int j1 = this.c(Block.bC.bO, 0);
      int l1 = this.c(Block.bC.bO, 1);
      this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, l1, 4L, 5, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, l1, 4L, 5, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, l1, 4L, 5, 9L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, l1, 4L, 5, 10L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, j1, 8L, 5, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, j1, 8L, 5, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, j1, 8L, 5, 9L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bC.bO, j1, 8L, 5, 10L, par3StructureBoundingBox);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 4, 4L, 4L, 4, 8L, Block.EntityAnimal.bO, Block.EntityAnimal.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 4, 4L, 9L, 4, 8L, Block.EntityAnimal.bO, Block.EntityAnimal.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 5, 4L, 4L, 5, 8L, Block.bD.bO, Block.bD.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 5, 4L, 9L, 5, 8L, Block.bD.bO, Block.bD.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 2, 0L, 8L, 2, 12L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 4L, 12L, 2, 8L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 0, 0L, 8L, 1, 3L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 0, 9L, 8L, 1, 12L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 4L, 3L, 1, 8L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 9L, 0, 4L, 12L, 1, 8L, Block.bA.bO, Block.bA.bO, false);

      for (int j2 = 4; j2 <= 8; j2++) {
         for (int l2 = 0; l2 <= 2; l2++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, j2, -1, l2, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, j2, -1, 12 - l2, par3StructureBoundingBox);
         }
      }

      for (int k2 = 0; k2 <= 2; k2++) {
         for (int i3 = 4; i3 <= 8; i3++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, k2, -1, i3, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, 12 - k2, -1, i3, par3StructureBoundingBox);
         }
      }

      return true;
   }
}
