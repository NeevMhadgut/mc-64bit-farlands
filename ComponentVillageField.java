import java.util.List;
import java.util.Random;

public class ComponentVillageField extends ComponentVillage {
   private int a = -1;

   public ComponentVillageField (int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static k findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, 0L, 0, 0L, 13L, 4, 9L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentVillageField (par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a < 0) {
         this.a = this.b(par1World, par3StructureBoundingBox);
         if (this.a < 0) {
            return true;
         }

         this.g.offset(0L, this.a - this.g.e + 4 - 1, 0L);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 0L, 12L, 4, 8L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 1L, 2L, 0, 7L, Block.aA.bO, Block.aA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 0, 1L, 5L, 0, 7L, Block.aA.bO, Block.aA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 0, 1L, 8L, 0, 7L, Block.aA.bO, Block.aA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 10L, 0, 1L, 11L, 0, 7L, Block.aA.bO, Block.aA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 0L, 0, 8L, Block.J.bO, Block.J.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 0, 0L, 6L, 0, 8L, Block.J.bO, Block.J.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 12L, 0, 0L, 12L, 0, 8L, Block.J.bO, Block.J.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 0L, 11L, 0, 0L, Block.J.bO, Block.J.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 8L, 11L, 0, 8L, Block.J.bO, Block.J.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 0, 1L, 3L, 0, 7L, Block.A.bO, Block.A.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 9L, 0, 1L, 9L, 0, 7L, Block.A.bO, Block.A.bO, false);

      for (int i = 1; i <= 7; i++) {
         this.placeBlockAtCurrentPosition(par1World, Block.TileEntityDispenser.bO, MathHelper.a(par2Random, 2, 7), 1L, 1, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.TileEntityDispenser.bO, MathHelper.a(par2Random, 2, 7), 2L, 1, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.TileEntityDispenser.bO, MathHelper.a(par2Random, 2, 7), 4L, 1, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.TileEntityDispenser.bO, MathHelper.a(par2Random, 2, 7), 5L, 1, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.TileEntityDispenser.bO, MathHelper.a(par2Random, 2, 7), 7L, 1, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.TileEntityDispenser.bO, MathHelper.a(par2Random, 2, 7), 8L, 1, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.TileEntityDispenser.bO, MathHelper.a(par2Random, 2, 7), 10L, 1, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.TileEntityDispenser.bO, MathHelper.a(par2Random, 2, 7), 11L, 1, i, par3StructureBoundingBox);
      }

      for (int j = 0; j < 9; j++) {
         for (int k = 0; k < 13; k++) {
            this.clearCurrentPositionBlocksUpwards(par1World, k, 4, j, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.v.bO, 0, k, -1, j, par3StructureBoundingBox);
         }
      }

      return true;
   }
}
