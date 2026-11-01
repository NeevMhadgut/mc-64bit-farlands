import java.util.List;
import java.util.Random;

public class ComponentStrongholdLibrary extends ComponentStronghold {
   private static final fx[] b = new fx[]{
      new fx(Item.aL.bQ, 0, 1, 3, 20), new fx(Item.aK.bQ, 0, 2, 7, 20), new fx(Item.bd.bQ, 0, 1, 1, 1), new fx(Item.aQ.bQ, 0, 1, 1, 1)
   };
   protected final mg a;
   private final boolean c;

   public ComponentStrongholdLibrary(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.a = this.a(par2Random);
      this.g = par3StructureBoundingBox;
      this.c = par3StructureBoundingBox.c() > 6;
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static ComponentStrongholdLibrary findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -4L, -1, 0L, 14L, 11, 15L, par5);
      if (!a(structureboundingbox) || StructureComponent.a(par0List, structureboundingbox) != null) {
         structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -4L, -1, 0L, 14L, 6, 15L, par5);
         if (!a(structureboundingbox) || StructureComponent.a(par0List, structureboundingbox) != null) {
            return null;
         }
      }

      return new ComponentStrongholdLibrary(par6, par1Random, structureboundingbox, par5);
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      byte byte0 = 11;
      if (!this.c) {
         byte0 = 6;
      }

      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 13L, byte0 - 1, 14L, true, par2Random, StructureStrongholdPieces.b());
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, this.a, 4L, 1, 0L);
      this.randomlyFillWithBlocks(par1World, par3StructureBoundingBox, par2Random, 0.07F, 2L, 1, 1L, 11L, 4, 13L, Block.W.bO, Block.W.bO, false);

      for (int i = 1; i <= 13; i++) {
         if ((i - 1) % 4 == 0) {
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, i, 1L, 4, i, Block.x.bO, Block.x.bO, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 12L, 1, i, 12L, 4, i, Block.x.bO, Block.x.bO, false);
            this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 2L, 3, i, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 11L, 3, i, par3StructureBoundingBox);
            if (this.c) {
               this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 6, i, 1L, 9, i, Block.x.bO, Block.x.bO, false);
               this.fillWithBlocks(par1World, par3StructureBoundingBox, 12L, 6, i, 12L, 9, i, Block.x.bO, Block.x.bO, false);
            }
         } else {
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, i, 1L, 4, i, Block.MapGenVillage.bO, Block.MapGenVillage.bO, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 12L, 1, i, 12L, 4, i, Block.MapGenVillage.bO, Block.MapGenVillage.bO, false);
            if (this.c) {
               this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 6, i, 1L, 9, i, Block.MapGenVillage.bO, Block.MapGenVillage.bO, false);
               this.fillWithBlocks(par1World, par3StructureBoundingBox, 12L, 6, i, 12L, 9, i, Block.MapGenVillage.bO, Block.MapGenVillage.bO, false);
            }
         }
      }

      for (int j = 3; j < 12; j += 2) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 1, j, 4L, 3, j, Block.MapGenVillage.bO, Block.MapGenVillage.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 1, j, 7L, 3, j, Block.MapGenVillage.bO, Block.MapGenVillage.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 9L, 1, j, 10L, 3, j, Block.MapGenVillage.bO, Block.MapGenVillage.bO, false);
      }

      if (this.c) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 5, 1L, 3L, 5, 13L, Block.x.bO, Block.x.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 10L, 5, 1L, 12L, 5, 13L, Block.x.bO, Block.x.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 5, 1L, 9L, 5, 2L, Block.x.bO, Block.x.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 5, 12L, 9L, 5, 13L, Block.x.bO, Block.x.bO, false);
         this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 9L, 5, 11L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 8L, 5, 11L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 9L, 5, 10L, par3StructureBoundingBox);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 6, 2L, 3L, 6, 12L, Block.aZ.bO, Block.aZ.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 10L, 6, 2L, 10L, 6, 10L, Block.aZ.bO, Block.aZ.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 6, 2L, 9L, 6, 2L, Block.aZ.bO, Block.aZ.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 6, 12L, 8L, 6, 12L, Block.aZ.bO, Block.aZ.bO, false);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 9L, 6, 11L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 8L, 6, 11L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 9L, 6, 10L, par3StructureBoundingBox);
         int k = this.c(Block.aF.bO, 3);
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, k, 10L, 1, 13L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, k, 10L, 2, 13L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, k, 10L, 3, 13L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, k, 10L, 4, 13L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, k, 10L, 5, 13L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, k, 10L, 6, 13L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, k, 10L, 7, 13L, par3StructureBoundingBox);
         byte byte1 = 7;
         byte byte2 = 7;
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1 - 1, 9, byte2, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1, 9, byte2, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1 - 1, 8, byte2, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1, 8, byte2, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1 - 1, 7, byte2, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1, 7, byte2, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1 - 2, 7, byte2, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1 + 1, 7, byte2, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1 - 1, 7, byte2 - 1, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1 - 1, 7, byte2 + 1, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1, 7, byte2 - 1, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, byte1, 7, byte2 + 1, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, byte1 - 2, 8, byte2, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, byte1 + 1, 8, byte2, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, byte1 - 1, 8, byte2 - 1, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, byte1 - 1, 8, byte2 + 1, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, byte1, 8, byte2 - 1, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, byte1, 8, byte2 + 1, par3StructureBoundingBox);
      }

      this.createTreasureChestAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 3L, 3, 5L, b, 1 + par2Random.nextInt(4));
      if (this.c) {
         this.placeBlockAtCurrentPosition(par1World, 0, 0, 12L, 9, 1L, par3StructureBoundingBox);
         this.createTreasureChestAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 12L, 8, 1L, b, 1 + par2Random.nextInt(4));
      }

      return true;
   }
}
