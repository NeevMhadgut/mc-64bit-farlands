import java.util.List;
import java.util.Random;

public class ComponentStrongholdRoomCrossing extends ComponentStronghold {
   private static final fx[] c = new fx[]{
      new fx(Item.o.bQ, 0, 1, 5, 10),
      new fx(Item.p.bQ, 0, 1, 3, 5),
      new fx(Item.aC.bQ, 0, 4, 9, 5),
      new fx(Item.m.bQ, 0, 3, 8, 10),
      new fx(Item.U.bQ, 0, 1, 3, 15),
      new fx(Item.j.bQ, 0, 1, 3, 15),
      new fx(Item.g.bQ, 0, 1, 1, 1)
   };
   protected final mg a;
   protected final int b;

   public ComponentStrongholdRoomCrossing(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.a = this.a(par2Random);
      this.g = par3StructureBoundingBox;
      this.b = par2Random.nextInt(5);
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.getNextComponentNormal((s)par1StructureComponent, par2List, par3Random, 4L, 1);
      this.getNextComponentX((s)par1StructureComponent, par2List, par3Random, 1, 4L);
      this.getNextComponentZ((s)par1StructureComponent, par2List, par3Random, 1, 4L);
   }

   public static ComponentStrongholdRoomCrossing findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -4L, -1, 0L, 11L, 7, 11L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentStrongholdRoomCrossing(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 10L, 6, 10L, true, par2Random, StructureStrongholdPieces.b());
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, this.a, 4L, 1, 0L);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 1, 10L, 6L, 3, 10L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 4L, 0L, 3, 6L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 10L, 1, 4L, 10L, 3, 6L, 0, 0, false);
      switch (this.b) {
         case 0:
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 5L, 1, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 5L, 2, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 5L, 3, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 4L, 3, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 6L, 3, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 5L, 3, 4L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 5L, 3, 6L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 4L, 1, 4L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 4L, 1, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 4L, 1, 6L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 6L, 1, 4L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 6L, 1, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 6L, 1, 6L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 5L, 1, 4L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 5L, 1, 6L, par3StructureBoundingBox);
            break;
         case 1:
            for (int i = 0; i < 5; i++) {
               this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 3L, 1, 3 + i, par3StructureBoundingBox);
               this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 7L, 1, 3 + i, par3StructureBoundingBox);
               this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 3 + i, 1, 3L, par3StructureBoundingBox);
               this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 3 + i, 1, 7L, par3StructureBoundingBox);
            }

            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 5L, 1, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 5L, 2, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 5L, 3, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.A.bO, 0, 5L, 4, 5L, par3StructureBoundingBox);
            break;
         case 2:
            for (int j = 1; j <= 9; j++) {
               this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 1L, 3, j, par3StructureBoundingBox);
               this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 9L, 3, j, par3StructureBoundingBox);
            }

            for (int k = 1; k <= 9; k++) {
               this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, k, 3, 1L, par3StructureBoundingBox);
               this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, k, 3, 9L, par3StructureBoundingBox);
            }

            this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 5L, 1, 4L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 5L, 1, 6L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 5L, 3, 4L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 5L, 3, 6L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 4L, 1, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 6L, 1, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 4L, 3, 5L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 6L, 3, 5L, par3StructureBoundingBox);

            for (int l = 1; l <= 3; l++) {
               this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 4L, l, 4L, par3StructureBoundingBox);
               this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 6L, l, 4L, par3StructureBoundingBox);
               this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 4L, l, 6L, par3StructureBoundingBox);
               this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 6L, l, 6L, par3StructureBoundingBox);
            }

            this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 5L, 3, 5L, par3StructureBoundingBox);

            for (int i1 = 2; i1 <= 8; i1++) {
               this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 2L, 3, i1, par3StructureBoundingBox);
               this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 3L, 3, i1, par3StructureBoundingBox);
               if (i1 <= 3 || i1 >= 7) {
                  this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 4L, 3, i1, par3StructureBoundingBox);
                  this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 5L, 3, i1, par3StructureBoundingBox);
                  this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 6L, 3, i1, par3StructureBoundingBox);
               }

               this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 7L, 3, i1, par3StructureBoundingBox);
               this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 8L, 3, i1, par3StructureBoundingBox);
            }

            this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, this.c(Block.aF.bO, 4), 9L, 1, 3L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, this.c(Block.aF.bO, 4), 9L, 2, 3L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aF.bO, this.c(Block.aF.bO, 4), 9L, 3, 3L, par3StructureBoundingBox);
            this.createTreasureChestAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 3L, 4, 8L, c, 1 + par2Random.nextInt(4));
      }

      return true;
   }
}
